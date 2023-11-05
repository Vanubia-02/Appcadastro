package com.example.appcadastro.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcadastro.R;

public class Telainicial extends AppCompatActivity {

    ImageView imgTi;
    TextView textTI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicial);

        imgTi = findViewById(R.id.imgTelaInicial);
        textTI= findViewById(R.id.textTelainicial);


    }
}