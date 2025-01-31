package com.rental.api.repository;

import com.rental.api.model.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Integer> {
    Optional<user> findByUsername(String username);
}