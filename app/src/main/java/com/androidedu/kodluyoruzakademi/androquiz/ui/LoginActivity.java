package com.androidedu.kodluyoruzakademi.androquiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.androidedu.kodluyoruzakademi.androquiz.R;
import com.androidedu.kodluyoruzakademi.androquiz.enums.BundleEnum;

public class LoginActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    private AppCompatEditText edtUserName = null, edtPassword = null;
    private AppCompatButton btnLogin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {

        edtUserName = (AppCompatEditText) findViewById(R.id.activity_login_edtUserName);
        edtPassword = (AppCompatEditText) findViewById(R.id.activity_login_edtUserPasword);
        btnLogin = (AppCompatButton) findViewById(R.id.activity_login_btnLogin);

        initEvent();
    }

    private void initEvent() {
        btnLogin.setEnabled(false);
        edtUserName.addTextChangedListener(this);
        edtPassword.addTextChangedListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void checkZeroPoint(CharSequence charSequence) {

        //hascode'lar hangi edittext'e ait oldugunu belirtir.
        if (charSequence.hashCode() == edtUserName.getText().hashCode()) {
            if (edtUserName.getText().toString().trim().startsWith("0")) {
                edtUserName.setText("");
            }
        }
    }

    private void checkLoginButtonStatus() {

        //iki edittext'inde karakter uzunlugu 0'a esit degilse buton aktif.
        if (edtUserName.getText().toString().trim().length() != 0 &&
                edtPassword.getText().toString().trim().length() != 0) {

            btnLogin.setEnabled(true);
        } else {
            btnLogin.setEnabled(false);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        //username icin 0 karakter girisini engelleyen method.
        checkZeroPoint(charSequence);

        //login butonun statusunu ayarliyor.
        checkLoginButtonStatus();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {

        Bundle bundle = new Bundle();

        //butona basildigi anda username ve password edittextlerinden bilgileri alip bundle'a veriyoruz.
        bundle.putString(BundleEnum.UserName.toString(), edtUserName.getText().toString().trim());
        bundle.putString(BundleEnum.UserPass.toString(), edtPassword.getText().toString().trim());

        Intent quizActivityIntent = new Intent(this, QuizActivity.class);

        quizActivityIntent.putExtras(bundle);

        startActivity(quizActivityIntent);

        //login ekranina geri donulmesini istemeyiz. O yuzden activity'i olduruyoruz.
        finish();
    }
}
