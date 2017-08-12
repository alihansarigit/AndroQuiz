package com.androidedu.kodluyoruzakademi.androquiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidedu.kodluyoruzakademi.androquiz.R;
import com.androidedu.kodluyoruzakademi.androquiz.enums.BundleEnum;

public class QuizActivity extends AppCompatActivity {

    TextView txt_username;
    public static Button Btn_devamet;
    QuizFragment fragment;
    public static String[] Verilen_Cevaplar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        fragment = (QuizFragment) getSupportFragmentManager().findFragmentById(R.id.activity_fragment);


        Bundle bundle = getIntent().getExtras();
        txt_username = (TextView) findViewById(R.id.txt_Username);
        txt_username.setText(bundle.getString(BundleEnum.UserName.toString()));
        Btn_devamet = (Button) findViewById(R.id.btn_devamet);
        Btn_devamet.setEnabled(false);
        Verilen_Cevaplar = new String[10];


    }

    public void activity_devamEt_OnClick(View view) {

        if(Btn_devamet.getText().equals("Sonucu Göster"))
        {
            Intent SonucActivity = new Intent(this, com.androidedu.kodluyoruzakademi.androquiz.ui.SonucActivity.class);
            startActivity(SonucActivity);
        }
        Verilen_Cevaplar[fragment.sayac-1] = fragment.TutulanCevap;
        System.out.println(Verilen_Cevaplar[fragment.sayac-1]);
        if (fragment.sayac <= fragment.soru.size() - 1) {
            fragment.VerileriYazdir(fragment.sayac);
            if (fragment.sayac == fragment.soru.size()) {
                Btn_devamet.setText("Sonucu Göster");
            }
        }

    }
}
