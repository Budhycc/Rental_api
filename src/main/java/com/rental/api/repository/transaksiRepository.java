package com.rental.api.repository;

import com.rental.api.model.transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transaksiRepository extends JpaRepository<transaksi, Integer> {
}
