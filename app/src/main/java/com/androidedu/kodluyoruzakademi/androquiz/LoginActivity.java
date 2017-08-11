package com.androidedu.kodluyoruzakademi.androquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText activity_login_edtKullaniciAdi, activity_login_edtKullaniciSifresi;
    Button activity_login_btnGirisYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nesneleriTanimla();
    }

    public void nesneleriTanimla() {
        activity_login_edtKullaniciAdi = (EditText) findViewById(R.id.activity_login_edtKullaniciAdi);
        activity_login_edtKullaniciSifresi = (EditText) findViewById(R.id.activity_login_edtKullaniciSifresi);
        activity_login_btnGirisYap = (Button) findViewById(R.id.activity_login_btnGirisYap);

        activity_login_btnGirisYap.setOnClickListener(this);

        filtreKoy();
    }


    @Override
    public void onUserInteraction() {
        if (activity_login_edtKullaniciAdi.getText().length() > 0 && activity_login_edtKullaniciSifresi.getText().length() > 0)
            activity_login_btnGirisYap.setEnabled(true);
        else
            activity_login_btnGirisYap.setEnabled(false);
        super.onUserInteraction();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btnGirisYap:
                Bundle bundle = new Bundle();
                bundle.putString(getString(R.string.kullaniciAdi), activity_login_edtKullaniciAdi.getText().toString());

                Intent intent = new Intent(this, QuizActivity.class);
                intent.putExtra("bilgi", bundle);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void filtreKoy() {
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                if (source.length() > 0 && Character.isWhitespace(source.charAt(0))) {
                    return "";
                }
                return source;
            }
        };
        activity_login_edtKullaniciAdi.setFilters(new InputFilter[]{filter});
    }


}
