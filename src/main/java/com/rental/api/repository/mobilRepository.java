package com.rental.api.repository;

import com.rental.api.model.mobil;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface mobilRepository extends JpaRepository<mobil, Integer> {
    Optional<mobil> findByPlatNomor(String platNomor);
}
