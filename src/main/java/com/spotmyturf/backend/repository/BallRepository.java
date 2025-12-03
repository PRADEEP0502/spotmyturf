package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.Ball;
import java.util.List;

public interface BallRepository extends JpaRepository<Ball, Long> {
    List<Ball> findByMatchIdOrderByCreatedAtDesc(Long matchId);
}
