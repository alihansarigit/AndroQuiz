package com.androidedu.kodluyoruzakademi.androquiz;


public class Soru {
    public int soruID;
    public String soru;
    public String dogruCevap;
    public String verilenCevap;
    public String sik1;
    public String sik2;
    public String sik3;
    public String sik4;


    public Soru(int soruID, String soru, String dogruCevap, String sik1, String sik2, String sik3, String sik4) {
        this.soruID = soruID;
        this.soru = soru;
        this.dogruCevap = dogruCevap;
        this.sik1 = sik1;
        this.sik2 = sik2;
        this.sik3 = sik3;
        this.sik4 = sik4;
    }


}
