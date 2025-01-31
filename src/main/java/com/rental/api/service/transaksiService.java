package com.rental.api.service;

import com.rental.api.model.transaksi;
// import com.rental.api.model.user;
import com.rental.api.repository.transaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class transaksiService {
    @Autowired
    private transaksiRepository repository;

    public List<transaksi> getAllTransaksi() {
        return repository.findAll();
    }

    public transaksi saveTransaksi(transaksi transaksi) {
        return repository.save(transaksi);
    }

    public transaksi updateTransaksi(int id, transaksi transaksiDetails) {
        return repository.findById(id).map(existingTransaksi -> {
            existingTransaksi.setPelanggan(transaksiDetails.getPelanggan());
            existingTransaksi.setTanggalMulai(transaksiDetails.getTanggalMulai());
            existingTransaksi.setTanggalSelesai(transaksiDetails.getTanggalSelesai());
            existingTransaksi.setTotalHarga(transaksiDetails.getTotalHarga());
            existingTransaksi.setDenda(transaksiDetails.getDenda());
            existingTransaksi.setStatus(transaksiDetails.getStatus());
            return repository.save(existingTransaksi);
        }).orElseThrow(() -> new IllegalArgumentException("Transaksi dengan ID " + id + " tidak ditemukan"));
    }

    public Optional<transaksi> getTransaksiById(int id) {
        return repository.findById(id);
    }

    public void deleteTransaksi(int id) {
        repository.deleteById(id);
    }
}
