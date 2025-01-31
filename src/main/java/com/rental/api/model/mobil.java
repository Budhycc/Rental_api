package com.rental.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "data_mobil")
public class mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMobil;

    @Column(nullable = false)
    private String merk;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int tahun;

    @Column(nullable = false, unique = true)
    private String platNomor;

    @Column(nullable = false)
    private String hargaSewaPerHari;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMobil status = StatusMobil.tersedia;

    // Enum untuk status
    public enum StatusMobil {
        tersedia,
        disewa
    }

    // Getter dan Setter
    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(String hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public StatusMobil getStatus() {
        return status;
    }

    public void setStatus(StatusMobil status) {
        this.status = status;
    }
}
