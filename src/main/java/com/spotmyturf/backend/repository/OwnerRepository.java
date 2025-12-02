package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spotmyturf.backend.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByPhone(String phone);

    boolean existsByPhone(String phone);
}
