package com.spotmyturf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spotmyturf.backend.model.*;
import com.spotmyturf.backend.repository.*;

import java.util.*;

@RestController
@RequestMapping("/api/match")
public class MatchScoreController {

    @Autowired private MatchRepository matchRepo;
    @Autowired private PlayerRepository playerRepo;
    @Autowired private PlayerStatsRepository statsRepo;
    @Autowired private BallRepository ballRepo;

    // CREATE MATCH
    @PostMapping("/create")
    public MatchEntity createMatch(@RequestBody Map<String,Object> req){
        MatchEntity m = new MatchEntity();
        m.setTeamA((String) req.get("teamA"));
        m.setTeamB((String) req.get("teamB"));
        m.setGround((String) req.get("ground"));
        m.setOvers((Integer) req.get("overs"));
        m.setStatus("CREATED");

        return matchRepo.save(m);
    }

    // ADD PLAYERS
    @PostMapping("/{matchId}/players")
    public String addPlayers(@PathVariable Long matchId, @RequestBody Map<String,Object> req){

        List<Map<String,String>> players = (List<Map<String,String>>) req.get("players");

        for(Map<String,String> p : players){
            Player player = new Player();
            player.setMatchId(matchId);
            player.setName(p.get("name"));
            player.setTeam(p.get("team"));
            Player saved = playerRepo.save(player);

            PlayerStats s = new PlayerStats();
            s.setMatchId(matchId);
            s.setPlayerId(saved.getId());
            statsRepo.save(s);
        }

        return "Players added";
    }

    // RECORD BALL
    @PostMapping("/{matchId}/ball")
    public String recordBall(@PathVariable Long matchId, @RequestBody Map<String,Object> req){

        Ball b = new Ball();
        b.setMatchId(matchId);
        b.setBatsmanId(Long.valueOf((Integer) req.get("batsmanId")));
        b.setBowlerId(Long.valueOf((Integer) req.get("bowlerId")));
        b.setRuns((Integer) req.get("runs"));
        b.setIsWicket((Boolean) req.get("isWicket"));
        b.setOverNumber((Integer) req.get("overNumber"));
        b.setBallNumber((Integer) req.get("ballNumber"));
        ballRepo.save(b);

        // Update match totals
        MatchEntity m = matchRepo.findById(matchId).get();
        m.setTotalRuns(m.getTotalRuns() + b.getRuns());
        if(b.getIsWicket()) m.setTotalWickets(m.getTotalWickets() + 1);

        double o = m.getCurrentOvers();
        o += 0.1;
        if(o % 1 >= 0.6) o = (int)o + 1;
        m.setCurrentOvers(o);
        matchRepo.save(m);

        // Update batsman
        PlayerStats bat = statsRepo.findByPlayerId(b.getBatsmanId());
        bat.setRuns(bat.getRuns() + b.getRuns());
        bat.setBalls(bat.getBalls() + 1);
        if(b.getRuns() == 4) bat.setFours(bat.getFours() + 1);
        if(b.getRuns() == 6) bat.setSixes(bat.getSixes() + 1);
        if(b.getIsWicket()) bat.setIsOut(true);
        statsRepo.save(bat);

        // Update bowler
        PlayerStats bowler = statsRepo.findByPlayerId(b.getBowlerId());
        bowler.setRunsGiven(bowler.getRunsGiven() + b.getRuns());
        bowler.setOversBowled(bowler.getOversBowled() + 0.1);
        if(b.getIsWicket()) bowler.setWickets(bowler.getWickets() + 1);
        statsRepo.save(bowler);

        return "Ball recorded";
    }

    // SCORECARD API
    @GetMapping("/{matchId}/scorecard")
    public Map<String,Object> scorecard(@PathVariable Long matchId){
        Map<String,Object> data = new HashMap<>();

        List<Player> players = playerRepo.findByMatchId(matchId);
        List<PlayerStats> stats = statsRepo.findByMatchId(matchId);

        List<Map<String,Object>> batters = new ArrayList<>();
        List<Map<String,Object>> bowlers = new ArrayList<>();

        for(Player p : players){
            PlayerStats s = statsRepo.findByPlayerId(p.getId());

            Map<String,Object> m = new HashMap<>();
            m.put("name", p.getName());
            m.put("runs", s.getRuns());
            m.put("balls", s.getBalls());
            m.put("fours", s.getFours());
            m.put("sixes", s.getSixes());
            m.put("isOut", s.getIsOut());

            if(p.getTeam().equals("A")) batters.add(m);
            else bowlers.add(m);
        }

        data.put("batters", batters);
        data.put("bowlers", bowlers);

        return data;
    }

    // MATCH SUMMARY
    @GetMapping("/{matchId}/summary")
    public Map<String,Object> summary(@PathVariable Long matchId){

        MatchEntity m = matchRepo.findById(matchId).get();
        List<PlayerStats> stats = statsRepo.findByMatchId(matchId);

        PlayerStats top = stats.stream().max(Comparator.comparing(PlayerStats::getRuns)).get();
        PlayerStats bestBowler = stats.stream().max(Comparator.comparing(PlayerStats::getWickets)).get();

        Map<String,Object> out = new HashMap<>();
        out.put("result", m.getTeamA() + " scored " + m.getTotalRuns() + "/" + m.getTotalWickets());
        out.put("topScorer", top.getPlayerId());
        out.put("bestBowler", bestBowler.getPlayerId());

        return out;
    }
}
