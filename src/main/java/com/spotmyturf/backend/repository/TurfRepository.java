package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.Turf;

import java.util.List;

public interface TurfRepository extends JpaRepository<Turf, Long> {

    List<Turf> findByOwnerId(Long ownerId);
}
