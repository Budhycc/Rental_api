package com.rental.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "data_transaksi")
public class transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan", nullable = false)
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "id_mobil", nullable = false)
    private mobil mobil;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date tanggalMulai;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date tanggalSelesai;

    @Column(nullable = false)
    private String totalHarga;

    @Column
    private String denda;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTransaksi status = StatusTransaksi.berlangsung;

    // Enum untuk status
    public enum StatusTransaksi {
        berlangsung,
        selesai
    }

    // Getter dan Setter
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public mobil getMobil() {
        return mobil;
    }

    public void setMobil(mobil mobil) {
        this.mobil = mobil;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getDenda() {
        return denda;
    }

    public void setDenda(String denda) {
        this.denda = denda;
    }

    public StatusTransaksi getStatus() {
        return status;
    }

    public void setStatus(StatusTransaksi status) {
        this.status = status;
    }
}
