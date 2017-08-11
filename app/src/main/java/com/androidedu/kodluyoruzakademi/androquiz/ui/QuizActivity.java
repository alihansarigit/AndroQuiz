package com.androidedu.kodluyoruzakademi.androquiz.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.androidedu.kodluyoruzakademi.androquiz.R;
import com.androidedu.kodluyoruzakademi.androquiz.enums.BundleEnum;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle bundle = getIntent().getExtras();
        Toast.makeText(this, bundle.getString(BundleEnum.UserName.toString(), "DefaultName"), Toast.LENGTH_SHORT).show();
    }
}
