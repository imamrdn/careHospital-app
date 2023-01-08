package com.example.carehospital_app.model;

public class Data {

    private String id, noAntrian, nama, jenisKelamin, tempatLahir, tanggalLahir, alamat, keluhan;

    public Data(){}

    public Data(String id, String noAntrian, String nama, String alamat, String keluhan) {
        this.id = id;
        this.noAntrian = noAntrian;
        this.nama = nama;
        this.alamat = alamat;
        this.keluhan = keluhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoAntrian() {
        return noAntrian;
    }

    public void setNoAntrian(String noAntrian) {
        this.noAntrian = noAntrian;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}
