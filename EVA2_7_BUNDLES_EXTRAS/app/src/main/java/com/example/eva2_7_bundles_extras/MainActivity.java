package com.example.eva2_7_bundles_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText edtTxtEnviar;
    Intent inEnviar;
    Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtEnviar = findViewById(R.id.edtTxtEnviar);
        btnEnviar = findViewById(R.id.button);
        btnEnviar.setOnClickListener(this);
    }

    public void onClick(View v){
        String x=edtTxtEnviar.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("el_bundle",x);
        bundle.putInt("Entero",150);
        inEnviar = new Intent(this, Otro.class);
        inEnviar.putExtra("Nombre",x);
        inEnviar.putExtra("datillos", 11.5);
        inEnviar.putExtras(bundle);
        startActivity(inEnviar);

    }
}
