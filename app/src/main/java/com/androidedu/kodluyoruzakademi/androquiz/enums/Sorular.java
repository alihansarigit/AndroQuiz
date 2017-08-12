package com.androidedu.kodluyoruzakademi.androquiz.enums;


/**
 * Created by emre on 12.8.2017.
 */

public class Sorular {

    public String SoruSayisi;
    public String SoruAdi;
    public String cevap1;
    public String cevap2;
    public String cevap3;
    public String cevap4;
    public String DogruCevap;
    public Sorular()
    {

    }
    public  Sorular(String _sorusayisi, String _soruadi, String _rdcevap1, String _rdcevap2, String _rdcevap3, String _rdcevap4,String Dogru)
    {
        this.SoruSayisi = _sorusayisi;
        this.SoruAdi = _soruadi;
        this.cevap1 = _rdcevap1;
        this.cevap2= _rdcevap2;
        this.cevap3 = _rdcevap3;
        this.cevap4 = _rdcevap4;
        this.DogruCevap = Dogru;
    }
}
