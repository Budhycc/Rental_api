package com.rental.api.controller;

// import com.rental.api.model.Pelanggan;
import com.rental.api.model.mobil;
import com.rental.api.service.mobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobil")
public class mobilController {
    @Autowired
    private mobilService service;

    @GetMapping
    public List<mobil> getAllMobil() {
        return service.getAllMobil();
    }

    // @PostMapping
    // public mobil createMobil(@RequestBody mobil mobil) {
    //     // return service.saveMobil(mobil);
    //     try {
    //         mobil savedMobil = service.saveMobil(mobil);
    //         return ResponseEntity.ok(savedMobil);
    //     } catch (IllegalArgumentException e) {
    //         return ResponseEntity.badRequest().body(e.getMessage());
    //     }
    // }
    @PostMapping
    public ResponseEntity<?> registerMobil(@RequestBody mobil mobil) {
        try {
            mobil savedMobil = service.saveMobil(mobil);
            return ResponseEntity.ok(savedMobil);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMobil(@PathVariable int id, @RequestBody mobil mobilDetails) {
        try {
            mobil updatedMobil = service.updateMobil(id, mobilDetails);
            return ResponseEntity.ok(updatedMobil);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<mobil> getMobilById(@PathVariable int id) {
        return service.getMobilById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteMobil(@PathVariable int id) {
        service.deleteMobil(id);
    }
}
