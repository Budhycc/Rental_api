package com.rental.api.service;

import com.rental.api.model.Pelanggan;
import com.rental.api.repository.PelangganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PelangganService {
    @Autowired
    private PelangganRepository repository;

    public List<Pelanggan> getAllPelanggan() {
        return repository.findAll();
    }

    public Pelanggan savePelanggan(Pelanggan pelanggan) {
        if (repository.findByEmail(pelanggan.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email nomor sudah digunakan!");
        }
        return repository.save(pelanggan);
    }

    public Pelanggan updatePelanggan(int id, Pelanggan pelangganDetails) {
        return repository.findById(id).map(existingPelanggan -> {
            existingPelanggan.setNama(pelangganDetails.getNama());
            existingPelanggan.setAlamat(pelangganDetails.getAlamat());
            existingPelanggan.setNoTelepon(pelangganDetails.getNoTelepon());
            existingPelanggan.setEmail(pelangganDetails.getEmail());
            return repository.save(existingPelanggan);
        }).orElseThrow(() -> new IllegalArgumentException("Pelanggan dengan ID " + id + " tidak ditemukan"));
    }

    public Optional<Pelanggan> getPelangganById(int id) {
        return repository.findById(id);
    }

    public void deletePelanggan(int id) {
        repository.deleteById(id);
    } 
}
