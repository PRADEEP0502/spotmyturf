package com.spotmyturf.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spotmyturf.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhone(String phone);

    boolean existsByPhone(String phone);
}
