package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.Player;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByMatchId(Long matchId);
}
