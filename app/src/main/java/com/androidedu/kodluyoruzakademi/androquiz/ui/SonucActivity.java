package com.androidedu.kodluyoruzakademi.androquiz.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidedu.kodluyoruzakademi.androquiz.R;

import static com.androidedu.kodluyoruzakademi.androquiz.ui.QuizActivity.Verilen_Cevaplar;
import static com.androidedu.kodluyoruzakademi.androquiz.ui.QuizFragment.soru;

public class SonucActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        LinearLayout lnr = (LinearLayout) findViewById(R.id.lnr_sonuc_layout);
        for(int i =0;Verilen_Cevaplar.length-1>=i;i++){
            if(Verilen_Cevaplar[i].toString()==soru.get(i).DogruCevap.toString())
            {
                TextView t1= new TextView(this);
                t1.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                t1.setBackgroundColor(Color.GREEN);
                t1.setText(soru.get(i).SoruSayisi +"    "+soru.get(i).DogruCevap+ " TRUE ");
                t1.setTypeface(null, Typeface.BOLD);
                lnr.addView(t1);
            }
            else
            {
                TextView t1= new TextView(this);
                t1.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT,LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
                t1.setBackgroundColor(Color.RED);
                t1.setTypeface(null, Typeface.BOLD);
                t1.setText(soru.get(i).SoruSayisi +"    "+soru.get(i).DogruCevap+ " FALSE ");
                lnr.addView(t1);
            }
        }

    }

}
