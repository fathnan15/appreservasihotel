package com.appreservasihotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pemesanan.doPemesanan(sc);
        sc.close();
    }
}
