package com.example.eva2_7_bundles_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Otro extends AppCompatActivity {
    TextView txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtDatos = findViewById(R.id.txtVwReciber);
        Intent inDatos = getIntent();
        String datos = inDatos.getStringExtra("Nombre");
        Double datos2 = inDatos.getDoubleExtra("datillos",0.0);
        Bundle bundle = inDatos.getExtras();

        txtDatos.setText(datos+", "+datos2);
        txtDatos.append("\n");
        txtDatos.append(bundle.getString("el_bundle")+" "+ bundle.getInt("Entero"));


    }
}
