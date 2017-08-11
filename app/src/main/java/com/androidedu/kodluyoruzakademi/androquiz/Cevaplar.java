package com.androidedu.kodluyoruzakademi.androquiz;


public class Cevaplar {
    private static final Cevaplar cevaplar = new Cevaplar();
    private static int sayacCevap = 0;
    private static String[][] cevapDizisi;

    private Cevaplar() {
        cevapDizisi = new String[10][2];
    }

    public static Cevaplar getInstance() {
        return cevaplar;
    }

    public static String[][] getCevapDizisi() {
        return cevapDizisi;
    }

    public static void setCevapDizisi(String[][] cevapDizisi) {
        Cevaplar.cevapDizisi[sayacCevap][0] = cevapDizisi[0][0];
        Cevaplar.cevapDizisi[sayacCevap][1] = cevapDizisi[0][1];

        sayacCevap++;
    }
}
