package com.example.manawa;

public class Ternak {

    private String nama, lokasi, harga, umur;

    public Ternak() {
    }

    public Ternak(String nama, String lokasi, String harga, String umur) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.harga = harga;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
}
