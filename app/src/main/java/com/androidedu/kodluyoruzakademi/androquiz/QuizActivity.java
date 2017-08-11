package com.androidedu.kodluyoruzakademi.androquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//TODO 17. MADDEYE KADAR YAPTIM. 17 DEN DEVAM EDİLECEK

public class QuizActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String kullaniciAdi = null, verilenCevap = null;
    TextView txtKullaniciAdi = null, txtSoruNumarasi = null, txtSoru = null;
    RadioGroup rdGroup;
    RadioButton rd1, rd2, rd3, rd4;
    Button btnCevapla;

    Soru[] sorular;
    int soruSayacı;

    String[][] cevap;

    CevapVM cevapVM;

    public static boolean cevapDorula(String dogruCevap, String verilenCevap) {
        return dogruCevap.equals(verilenCevap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        nesneleriTanimla();
        sorulariDoldur();
        soruYazdir();
    }

    public void nesneleriTanimla() {
        Bundle extra = getIntent().getBundleExtra(getString(R.string.bilgi));
        kullaniciAdi = extra.getString(getString(R.string.kullaniciAdi));

        txtKullaniciAdi = (TextView) findViewById(R.id.activity_quiz_txtKullaniciAdi);
        txtSoruNumarasi = (TextView) findViewById(R.id.activity_quiz_txtSoruNumarasi);
        txtSoru = (TextView) findViewById(R.id.activity_quiz_txtSoru);

        rdGroup = (RadioGroup) findViewById(R.id.activity_quiz_rdGroup);
        rd1 = (RadioButton) findViewById(R.id.activity_quiz_rd1);
        rd2 = (RadioButton) findViewById(R.id.activity_quiz_rd2);
        rd3 = (RadioButton) findViewById(R.id.activity_quiz_rd3);
        rd4 = (RadioButton) findViewById(R.id.activity_quiz_rd4);

        btnCevapla = (Button) findViewById(R.id.activity_quiz_btnCevapla);

        btnCevapla.setOnClickListener(this);
        rdGroup.setOnCheckedChangeListener(this);

        txtKullaniciAdi.setText(kullaniciAdi);

        sorular = new Soru[10];
        soruSayacı = 0;

        cevapVM = new CevapVM();
    }

    public void sorulariDoldur() {

        Soru s1 = new Soru(0, "Hangisi Araba?", "Elektrikli Otomobil", "Arkadaş", "At", "Elektrikli Otomobil", "Gemi");
        Soru s2 = new Soru(1, "Hangisi At?", "Arap Atı", "Çekçek", "Arap Atı", "Tren", "Bisiklet");
        Soru s3 = new Soru(2, "Hangisi Çiçek?", "Gül", "Tahta", "Telefon", "Gül", "Köpek");
        Soru s4 = new Soru(3, "Hangisi Balık?", "Çinekop", "Karga", "Çinekop", "Kartal", "Kedi");
        Soru s5 = new Soru(4, "Hangisi Araba Markası?", "BMW", "BMW", "Acer", "LG", "Nokia");
        Soru s6 = new Soru(5, "Türkiye Başkenti?", "Ankara", "İstanbul", "İzmir", "Adana Merkez", "Ankara");
        Soru s7 = new Soru(6, "Dünyada Kaç Uzaylı Var?", "0", "420", "102", "0", "15");
        Soru s8 = new Soru(7, "Bir Elde Kaç Parmak Var?", "5", "3", "5", "7", "10");
        Soru s9 = new Soru(8, "Kaç Kulağın Var?", "2", "2", "3", "4", "7");
        Soru s10 = new Soru(9, "Kaç Burnun Var", "1", "2", "Yok", "3", "1");

        sorular[0] = s1;
        sorular[1] = s2;
        sorular[2] = s3;
        sorular[3] = s4;
        sorular[4] = s5;
        sorular[5] = s6;
        sorular[6] = s7;
        sorular[7] = s8;
        sorular[8] = s9;
        sorular[9] = s10;
    }

    public void soruYazdir() {

        if (soruSayacı < sorular.length) {
            txtSoruNumarasi.setText(String.valueOf(soruSayacı + 1));

            if (soruSayacı + 1 == sorular.length)
                btnCevapla.setText("SONUÇ");

            txtSoru.setText(sorular[soruSayacı].soru);

            rd1.setText(sorular[soruSayacı].sik1);
            rd2.setText(sorular[soruSayacı].sik2);
            rd3.setText(sorular[soruSayacı].sik3);
            rd4.setText(sorular[soruSayacı].sik4);

            soruSayacı++;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_quiz_btnCevapla:
                if (soruSayacı < sorular.length) {
                    sorular[soruSayacı - 1].verilenCevap = verilenCevap;

                    cevap = new String[1][2];
                    cevap[0][0] = sorular[soruSayacı - 1].dogruCevap;
                    cevap[0][1] = sorular[soruSayacı - 1].verilenCevap;

                    Cevaplar.setCevapDizisi(cevap);

                    RadioButton rb = (RadioButton) findViewById(rdGroup.getCheckedRadioButtonId());
                    rb.setChecked(false);

                    soruYazdir();
                    btnCevapla.setEnabled(false);
                } else {
                    for (int i = 0; i < Cevaplar.getCevapDizisi().length; i++) {
                        cevapVM.soru[i] = sorular[i].soru;
                        cevapVM.cevap[i] = cevapDorula(sorular[i].dogruCevap, sorular[i].verilenCevap);
                    }

                    Intent intent = new Intent(this, SonucActivity.class);
                    intent.putExtra("cevapVM", cevapVM);
                    intent.putExtra("kullaniciAdi", kullaniciAdi);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.activity_quiz_rd1:
                verilenCevap = rd1.getText().toString();
                btnCevapla.setEnabled(true);
                break;
            case R.id.activity_quiz_rd2:
                verilenCevap = rd2.getText().toString();
                btnCevapla.setEnabled(true);
                break;
            case R.id.activity_quiz_rd3:
                verilenCevap = rd3.getText().toString();
                btnCevapla.setEnabled(true);
                break;
            case R.id.activity_quiz_rd4:
                verilenCevap = rd4.getText().toString();
                btnCevapla.setEnabled(true);
                break;
            default:
                break;
        }
    }


}
