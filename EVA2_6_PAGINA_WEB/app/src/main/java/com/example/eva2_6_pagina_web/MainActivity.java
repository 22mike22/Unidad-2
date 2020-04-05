package com.example.eva2_6_pagina_web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent inWeb;
    EditText edtTxtPag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtPag = findViewById(R.id.edtTxtPag);
    }

    public void onClick(View v){
        String dirWeb = "http://"+edtTxtPag.getText().toString();
        inWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(dirWeb));
        startActivity(inWeb);
    }
}
