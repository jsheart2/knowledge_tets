package com.knowledge_tets.Data;

public class Updatedata {
    private String namalengkap, namapanggilan, nohp, email, jeniskelamin, alamat, pekerjaan;

    public Updatedata(){}

    public Updatedata(String namalengkap, String namapanggilan, String nohp, String email, String jeniskelamin, String alamat, String pekerjaan) {
        this.namalengkap = namalengkap;
        this.namapanggilan = namapanggilan;
        this.nohp = nohp;
        this.email = email;
        this.jeniskelamin = jeniskelamin;
        this.alamat = alamat;
        this.pekerjaan = pekerjaan;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getNamapanggilan() {
        return namapanggilan;
    }

    public void setNamapanggilan(String namapanggilan) {
        this.namapanggilan = namapanggilan;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
}

