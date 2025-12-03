package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.MatchEntity;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {}
