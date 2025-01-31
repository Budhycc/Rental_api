package com.rental.api.controller;

// import com.rental.api.model.Pelanggan;
import com.rental.api.model.transaksi;
import com.rental.api.service.transaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaksi")
public class transaksiController {
    @Autowired
    private transaksiService service;

    @GetMapping
    public List<transaksi> getAllTransaksi() {
        return service.getAllTransaksi();
    }

    @PostMapping
    public transaksi createTransaksi(@RequestBody transaksi transaksi) {
        return service.saveTransaksi(transaksi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaksi(@PathVariable int id, @RequestBody transaksi transaksiDetails) {
        try {
            transaksi updateTransaksi = service.updateTransaksi(id, transaksiDetails);
            return ResponseEntity.ok(updateTransaksi);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    } 

    @GetMapping("/{id}")
    public ResponseEntity<transaksi> getTransaksiById(@PathVariable int id) {
        return service.getTransaksiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteTransaksi(@PathVariable int id) {
        service.deleteTransaksi(id);
    }
}
