package com.rental.api.repository;

import com.rental.api.model.Pelanggan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository extends JpaRepository<Pelanggan, Integer> {
    Optional<Pelanggan> findByEmail(String email);
}
