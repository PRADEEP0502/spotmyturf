package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.PlayerStats;
import java.util.List;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
    PlayerStats findByPlayerId(Long playerId);
    List<PlayerStats> findByMatchId(Long matchId);
}
