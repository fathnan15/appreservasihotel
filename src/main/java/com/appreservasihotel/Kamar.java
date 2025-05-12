package com.appreservasihotel;

public class Kamar {
    private int nomor;
    private String tipe;
    private int hargaPerMalam;
    private boolean tersedia;

    public Kamar(int nomor, String tipe, int hargaPerMalam, boolean tersedia) {
        this.nomor = nomor;
        this.tipe = tipe;
        this.hargaPerMalam = hargaPerMalam;
        this.tersedia = tersedia;
    }

    public int getNomor() {
        return nomor;
    }

    public String getTipe() {
        return tipe;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public static final Kamar[] daftarKamar = {
            new Kamar(101, "Standar", 200_000, true),
            new Kamar(102, "Superior", 300_000, true),
            new Kamar(201, "Deluxe", 500_000, true),
            new Kamar(301, "Suite", 800_000, true)
    };
}
