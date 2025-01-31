package com.rental.api.service;
    
// import com.rental.api.model.Pelanggan;
import com.rental.api.model.mobil;
import com.rental.api.repository.mobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mobilService {
    @Autowired
    private mobilRepository repository;

    public List<mobil> getAllMobil() {
        return repository.findAll();
    }

    public mobil saveMobil(mobil mobil) {
        // return repository.save(mobil);
        if (repository.findByPlatNomor(mobil.getPlatNomor()).isPresent()) {
            throw new IllegalArgumentException("Plat nomor sudah digunakan!");
        }
        return repository.save(mobil);
    }

    public mobil updateMobil(int id, mobil mobilDetails) {
        return repository.findById(id).map(existingMobil -> {
            existingMobil.setMerk(mobilDetails.getMerk());
            existingMobil.setModel(mobilDetails.getModel());
            existingMobil.setTahun(mobilDetails.getTahun());
            existingMobil.setPlatNomor(mobilDetails.getPlatNomor());
            existingMobil.setHargaSewaPerHari(mobilDetails.getHargaSewaPerHari());
            existingMobil.setStatus(mobilDetails.getStatus());
            return repository.save(existingMobil);
        }).orElseThrow(() -> new IllegalArgumentException("Mobil dengan ID " + id + " tidak ditemukan"));
    }

    public Optional<mobil> getMobilById(int id) {
        return repository.findById(id);
    }

    public void deleteMobil(int id) {
        repository.deleteById(id);
    }
}
