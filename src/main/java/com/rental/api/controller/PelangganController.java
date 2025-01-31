package com.rental.api.controller;

import com.rental.api.model.Pelanggan;
import com.rental.api.service.PelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService service;

    @GetMapping
    public List<Pelanggan> getAllPelanggan() {
        return service.getAllPelanggan();
    }

    @PostMapping
    public ResponseEntity<?> createPelanggan(@RequestBody Pelanggan pelanggan) {
        // return service.savePelanggan(Pelanggan);
        try {
            Pelanggan createPelanggan = service.savePelanggan(pelanggan);
            return ResponseEntity.ok(createPelanggan);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePelanggan(@PathVariable int id, @RequestBody Pelanggan pelangganDetails) {
        try {
            Pelanggan updatedPelanggan = service.updatePelanggan(id, pelangganDetails);
            return ResponseEntity.ok(updatedPelanggan);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Pelanggan> getPelangganById(@PathVariable int id) {
        return service.getPelangganById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletePelanggan(@PathVariable int id) {
        service.deletePelanggan(id);
    }
}
