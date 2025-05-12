package com.appreservasihotel;

public class CetakStruk {
    public static void cetakStruk(Kamar k, int malam) {
        int dasar = k.getHargaPerMalam() * malam;
        double pajak = 0.1 * dasar;
        int layanan = 50_000;
        double total = dasar + pajak + layanan;
        String bonusInfo = "";

        if (total > 500_000) {
            total *= 0.85;
            bonusInfo = "Diskon 15% diterapkan.";
        } else if (total > 300_000) {
            bonusInfo = "Gratis sarapan.";
        }

        System.out.println("\n--- STRUK RESERVASI ---");
        System.out.printf("Kamar        : %d (%s)%n", k.getNomor(), k.getTipe());
        System.out.printf("Lama inap    : %d malam%n", malam);
        System.out.printf("Biaya dasar  : Rp %,d%n", dasar);
        System.out.printf("Pajak 10%%     : Rp %,d%n", (int) pajak);
        System.out.printf("Biaya layanan: Rp %,d%n", layanan);
        if (!bonusInfo.isEmpty())
            System.out.println(bonusInfo);
        System.out.printf("TOTAL BAYAR  : Rp %,d%n", (int) total);
        System.out.println("------------------------");
    }
}
