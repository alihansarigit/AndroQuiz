package com.androidedu.kodluyoruzakademi.androquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {

    CevapVM cevapVM;
    String kullaniciAdi;

    TextView txtKullaniciAdi = null;

    TextView[] txtSorular;
    TextView[] txtCevaplar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        Bundle data = getIntent().getExtras();
        cevapVM = data.getParcelable("cevapVM");
        kullaniciAdi = data.getString("kullaniciAdi");

        nesneleriDoldur();
        ekraniDoldur();
        renklendir();
    }

    public void nesneleriDoldur() {

        txtKullaniciAdi = (TextView) findViewById(R.id.activity_sonuc_txtKullaniciAdi);

        txtSorular = new TextView[10];
        txtCevaplar = new TextView[10];

        txtSorular[0] = (TextView) findViewById(R.id.activity_sonuc_txtSoru1);
        txtSorular[1] = (TextView) findViewById(R.id.activity_sonuc_txtSoru2);
        txtSorular[2] = (TextView) findViewById(R.id.activity_sonuc_txtSoru3);
        txtSorular[3] = (TextView) findViewById(R.id.activity_sonuc_txtSoru4);
        txtSorular[4] = (TextView) findViewById(R.id.activity_sonuc_txtSoru5);
        txtSorular[5] = (TextView) findViewById(R.id.activity_sonuc_txtSoru6);
        txtSorular[6] = (TextView) findViewById(R.id.activity_sonuc_txtSoru7);
        txtSorular[7] = (TextView) findViewById(R.id.activity_sonuc_txtSoru8);
        txtSorular[8] = (TextView) findViewById(R.id.activity_sonuc_txtSoru9);
        txtSorular[9] = (TextView) findViewById(R.id.activity_sonuc_txtSoru10);

        txtCevaplar[0] = (TextView) findViewById(R.id.activity_sonuc_txtCevap1);
        txtCevaplar[1] = (TextView) findViewById(R.id.activity_sonuc_txtCevap2);
        txtCevaplar[2] = (TextView) findViewById(R.id.activity_sonuc_txtCevap3);
        txtCevaplar[3] = (TextView) findViewById(R.id.activity_sonuc_txtCevap4);
        txtCevaplar[4] = (TextView) findViewById(R.id.activity_sonuc_txtCevap5);
        txtCevaplar[5] = (TextView) findViewById(R.id.activity_sonuc_txtCevap6);
        txtCevaplar[6] = (TextView) findViewById(R.id.activity_sonuc_txtCevap7);
        txtCevaplar[7] = (TextView) findViewById(R.id.activity_sonuc_txtCevap8);
        txtCevaplar[8] = (TextView) findViewById(R.id.activity_sonuc_txtCevap9);
        txtCevaplar[9] = (TextView) findViewById(R.id.activity_sonuc_txtCevap10);
    }

    public void ekraniDoldur() {
        txtKullaniciAdi.setText(kullaniciAdi);

        for (int i = 0; i < txtSorular.length; i++) {
            txtSorular[i].setText(cevapVM.soru[i]);
            txtCevaplar[i].setText(String.valueOf((cevapVM.cevap[i]) ? getString(R.string.Dogru) : getString(R.string.Yanlis)));
        }
    }

    public void renklendir() {
        for (int i = 0; i < txtCevaplar.length; i++) {
            if ((txtCevaplar[i].getText()).equals("Doğru"))
                txtCevaplar[i].setTextColor(getResources().getColor(R.color.turuncu));
            else
                txtCevaplar[i].setTextColor(getResources().getColor(R.color.kirmizi));
        }
    }


}
