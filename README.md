# Aplikasi Reservasi Hotel

Sebuah aplikasi konsol sederhana untuk memesan kamar hotel berbasis Java, menggunakan rekursi untuk pengulangan alur input dan konfirmasi tanpa menggunakan `for`/`while`. Proyek ini terdiri dari empat kelas terpisah, masing-masing bertanggung jawab atas model data, alur pemesanan, pencetakan struk, dan titik masuk aplikasi.

---

## Daftar Isi

- [Fitur Utama](#fitur-utama)  
- [Prasyarat](#prasyarat)  
- [Struktur Proyek](#struktur-proyek)  
- [Instalasi & Kompilasi](#instalasi--kompilasi)  
- [Menjalankan Aplikasi](#menjalankan-aplikasi)  
- [Alur Eksekusi Lengkap](#alur-eksekusi-lengkap)  
- [Penjelasan Kode per Kelas](#penjelasan-kode-per-kelas)  

---

## Fitur Utama

1. **Daftar Kamar**  
   – 4 tipe (Standar, Superior, Deluxe, Suite) dengan harga dan status tersedia.  
2. **Pemesanan Interaktif**  
   – Input nomor kamar & lama inap, ringkasan biaya, konfirmasi “Y/N”.  
   – Batal → ulangi proses (rekursi), Konfirmasi → cetak struk & keluar.  
3. **Perhitungan Biaya**  
   – Biaya dasar = tarif × malam  
   – Pajak 10%  
   – Biaya layanan Rp 50.000 per kamar  
   – Diskon 15% untuk total awal > Rp 500.000  
   – Gratis sarapan untuk total awal > Rp 300.000  
4. **Struk Reservasi**  
   – Rincian kamar, lama inap, biaya dasar, pajak, layanan, diskon/bonus, total akhir.

---

## Prasyarat

- Java SE Development Kit (JDK) 21 atau lebih baru  
- VS Code (opsional) atau IDE Java lain  
- Terminal Bash (menggunakan Ubuntu atau Linux lain)

---

## Struktur Proyek

```
appreservasihotel/
├─ src/
│  └─ main/
│     └─ java/
│        └─ com/
│           └─ appreservasihotel/
│              ├─ Kamar.java
│              ├─ Pemesanan.java
│              ├─ CetakStruk.java
│              └─ Main.java
└─ README.md
```

---

## Instalasi & Kompilasi

1. **Clone repo** (jika belum):  
   ```bash
   git clone https://github.com/fathnan15/appreservasihotel.git
   cd appreservasihotel
   ```
2. **Kompilasi seluruh kelas**:  
   ```bash
   javac -d out src/main/java/com/appreservasihotel/*.java
   ```
   – Flag `-d out` menempatkan `.class` di folder `out/` sesuai struktur paket.  
3. **Jalankan**:  
   ```bash
   java -cp out com.appreservasihotel.Main
   ```

---

## Menjalankan Aplikasi

Setelah perintah `java` di atas, aplikasi akan menampilkan daftar kamar dan prompt:

1. **Daftar Kamar**  
   ```
   === Daftar Kamar Tersedia ===
   101 – Standar  – Rp 200.000
   102 – Superior – Rp 300.000
   201 – Deluxe   – Rp 500.000
   301 – Suite    – Rp 800.000
   ```
2. **Input Pemesanan**  
   ```
   Nomor Kamar   : [masukkan, mis. 102]
   Lama menginap : [masukkan, mis. 2]
   ```
3. **Konfirmasi**  
   ```
   Anda memilih Kamar 102 (Superior) – 2 malam – Biaya dasar: Rp 600.000
   Konfirmasi pemesanan? (Y/N):
   ```
4. **Jika “Y”** → tampilkan struk lengkap & program selesai.  
   **Jika “N”** → tampil “Pemesanan dibatalkan.” dan kembali ke langkah 1 (rekursi).

---

## Alur Eksekusi Lengkap

1. **`Main.main()`**  
   - Membuat objek `Scanner sc`.  
   - Memanggil `Pemesanan.doPemesanan(sc)`.  
   - Setelah selesai, `sc.close()` dan program berakhir.

2. **`Pemesanan.doPemesanan(Scanner sc)`**  
   1. **Tampilkan daftar kamar**  
      - Empat blok `if` memeriksa `Kamar.daftarKamar[i].isTersedia()`.  
      - Cetak nomor, tipe, dan harga tiap kamar yang tersedia.  
   2. **Baca input**  
      - `nomor` via `sc.nextInt()`  
      - `malam` via `sc.nextInt()`  
      - Buang newline dengan `sc.nextLine()`.  
   3. **Cari objek `Kamar pilih`**  
      - Empat pengecekan `if–else if`:  
        - Jika `nomor == 101` & `daftarKamar[0].isTersedia()`, pilih `daftarKamar[0]`  
        - … hingga `nomor == 301`.  
      - Jika `pilih == null`, tampil pesan error & **rekursi** ulang ke langkah awal.  
   4. **Ringkasan & konfirmasi**  
      - Hitung `biayaDasar = pilih.getHargaPerMalam() * malam`.  
      - Cetak ringkasan pilihan & biaya dasar.  
      - Minta input `Y`/`N` via `sc.nextLine()`.  
      - Jika `Y` → `CetakStruk.cetakStruk(pilih, malam)` & **tidak** kembali.  
      - Jika `N` → tampil pesan batal & **rekursi** ulang.

3. **`CetakStruk.cetakStruk(Kamar k, int malam)`**  
   1. Hitung `dasar`, `pajak = 0.1 * dasar`, `layanan = 50_000`.  
   2. Hitung `total = dasar + pajak + layanan`.  
   3. Jika `total > 500_000` → diskon 15% (total ×= 0.85).  
   4. Else jika `total > 300_000` → catat “Gratis sarapan.”  
   5. Cetak rincian struk.

4. **Akhir Program**  
   - Setelah `cetakStruk`, method `doPemesanan` selesai → kembali ke `main` → scanner ditutup → program berakhir.

---

## Penjelasan Kode per Kelas

**Kamar.java**  
- Model data kamar dan array statis `daftarKamar[]`.  

**Pemesanan.java**  
- Metode `doPemesanan` untuk interaksi dan rekursi.  

**CetakStruk.java**  
- Metode `cetakStruk` untuk perhitungan dan pencetakan struk.  

**Main.java**  
- Entry point yang memulai `doPemesanan` dan menutup scanner.

---
