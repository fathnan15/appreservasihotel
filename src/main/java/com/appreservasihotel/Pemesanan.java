package com.appreservasihotel;

import java.util.Scanner;

public class Pemesanan {

    public static void doPemesanan(Scanner sc) {
        System.out.println("=== Daftar Kamar Tersedia ===");
        if (Kamar.daftarKamar[0].isTersedia())
            System.out.printf("101 - %s - Rp %,d%n",
                    Kamar.daftarKamar[0].getTipe(),
                    Kamar.daftarKamar[0].getHargaPerMalam());
        if (Kamar.daftarKamar[1].isTersedia())
            System.out.printf("102 - %s - Rp %,d%n",
                    Kamar.daftarKamar[1].getTipe(),
                    Kamar.daftarKamar[1].getHargaPerMalam());
        if (Kamar.daftarKamar[2].isTersedia())
            System.out.printf("201 - %s - Rp %,d%n",
                    Kamar.daftarKamar[2].getTipe(),
                    Kamar.daftarKamar[2].getHargaPerMalam());
        if (Kamar.daftarKamar[3].isTersedia())
            System.out.printf("301 - %s - Rp %,d%n",
                    Kamar.daftarKamar[3].getTipe(),
                    Kamar.daftarKamar[3].getHargaPerMalam());
        System.out.println();

        System.out.print("Nomor Kamar   : ");
        int nomor = sc.nextInt();
        System.out.print("Lama menginap : ");
        int malam = sc.nextInt();
        sc.nextLine();

        Kamar pilih = null;
        if (nomor == 101 && Kamar.daftarKamar[0].isTersedia())
            pilih = Kamar.daftarKamar[0];
        else if (nomor == 102 && Kamar.daftarKamar[1].isTersedia())
            pilih = Kamar.daftarKamar[1];
        else if (nomor == 201 && Kamar.daftarKamar[2].isTersedia())
            pilih = Kamar.daftarKamar[2];
        else if (nomor == 301 && Kamar.daftarKamar[3].isTersedia())
            pilih = Kamar.daftarKamar[3];

        if (pilih == null) {
            System.out.println("Kamar tidak valid atau sudah dipesan. Silakan ulangi.\n");
            doPemesanan(sc);
            return;
        }

        int biayaDasar = pilih.getHargaPerMalam() * malam;
        System.out.printf(
                "Anda memilih Kamar %d (%s) - %d malam - Biaya dasar: Rp %,d%n",
                pilih.getNomor(), pilih.getTipe(), malam, biayaDasar);
        System.out.print("Konfirmasi pemesanan? (Y/N): ");
        String jawaban = sc.nextLine().trim().toUpperCase();

        if ("Y".equals(jawaban)) {
            CetakStruk.cetakStruk(pilih, malam);
        } else {
            System.out.println("Pemesanan dibatalkan. Mengulangi...\n");
            doPemesanan(sc);
        }
    }
}
