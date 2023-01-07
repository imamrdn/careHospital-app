package com.example.carehospital_app.Model;

import java.util.List;

public class HospitalResponseModel {
    private int id;
    private String nama, alamat, kota;
    private List<HospitalDataModel> rumahsakit;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getAlamat() {return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat;}

    public String getKota() { return kota; }
    public void setKota(String kota) { this.kota = kota; }

    public List<HospitalDataModel> getRumahsakit() { return rumahsakit; }
    public void setRumahsakit(List<HospitalDataModel> rumahsakit) {
        this.rumahsakit = rumahsakit;
    }
}
