package com.androidedu.kodluyoruzakademi.androquiz.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.androidedu.kodluyoruzakademi.androquiz.R;
import com.androidedu.kodluyoruzakademi.androquiz.enums.Sorular;

import java.util.ArrayList;

import static com.androidedu.kodluyoruzakademi.androquiz.ui.QuizActivity.Btn_devamet;

public class QuizFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView txt_sorusayisi;
    TextView txt_soruadi;
    RadioButton rd_cevap1;
    RadioButton rd_cevap2;
    RadioButton rd_cevap3;
    RadioButton rd_cevap4;
    String TutulanCevap;
    Sorular[] s;
    public static ArrayList<Sorular> soru;
    Boolean onay = false;
    static int sayac = 0;
    View v;
    RadioGroup rg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_quiz, container, false);
        rg = v.findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
        txt_sorusayisi = v.findViewById(R.id.txt_sorusayisi);
        txt_soruadi = v.findViewById(R.id.txt_soruadi);
        rd_cevap1 = v.findViewById(R.id.rd_cevap1);
        rd_cevap2 = v.findViewById(R.id.rd_cevap2);
        rd_cevap3 = v.findViewById(R.id.rd_cevap3);
        rd_cevap4 = v.findViewById(R.id.rd_cevap4);
        Sorular s1 = new Sorular("Soru 1", "Bu Kaçıncı Soru", "1", "2", "3", "4", "1");
        Sorular s2 = new Sorular("Soru 2", "Bu Kaçıncı Soru", "1", "2", "8", "4", "2");
        Sorular s3 = new Sorular("Soru 3", "Bu Kaçıncı Soru", "1", "2", "3", "4", "3");
        Sorular s4 = new Sorular("Soru 4", "Bu Kaçıncı Soru", "1", "2", "4", "8", "4");
        Sorular s5 = new Sorular("Soru 5", "Bu Kaçıncı Soru", "1", "5", "3", "4", "5");
        Sorular s6 = new Sorular("Soru 6", "Bu Kaçıncı Soru", "1", "6", "3", "4", "6");
        Sorular s7 = new Sorular("Soru 7", "Bu Kaçıncı Soru", "1", "7", "3", "4", "7");
        Sorular s8 = new Sorular("Soru 8", "Bu Kaçıncı Soru", "1", "8", "3", "4", "8");
        Sorular s9 = new Sorular("Soru 9", "Bu Kaçıncı Soru", "1", "9", "3", "4", "9");
        Sorular s10 = new Sorular("Soru 10", "Bu Kaçıncı Soru", "10", "2", "3", "4", "10");

        soru = new ArrayList<>();
        soru.add(s1);
        soru.add(s2);
        soru.add(s3);
        soru.add(s4);
        soru.add(s5);
        soru.add(s6);
        soru.add(s7);
        soru.add(s8);
        soru.add(s9);
        soru.add(s10);
        VerileriYazdir(sayac);


        return v;
    }

    public void VerileriYazdir(int i) {
        txt_sorusayisi.setText(soru.get(i).SoruSayisi);
        txt_soruadi.setText(soru.get(i).SoruAdi);
        rd_cevap1.setText(soru.get(i).cevap1);
        rd_cevap2.setText(soru.get(i).cevap2);
        rd_cevap3.setText(soru.get(i).cevap3);
        rd_cevap4.setText(soru.get(i).cevap4);
        sayac++;
        if (rg.getCheckedRadioButtonId() != -1) {
            rg.clearCheck();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            RadioButton rbx = v.findViewById(i);
            Btn_devamet.setEnabled(true);
            TutulanCevap = rbx.getText().toString();

        } else {
            Btn_devamet.setEnabled(false);
        }

    }
}
