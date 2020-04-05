package com.example.eva2_3_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtNum, edtTxtMens;
    Button btnEnviar;
    Intent enviarSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar=findViewById(R.id.btnEnviar);
        edtTxtNum  = findViewById(R.id.edtTxtNum);
        edtTxtMens=findViewById(R.id.edtTxtMens);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sMen=edtTxtMens.getText().toString();
                String sTel="smsto:"+edtTxtNum.getText().toString();
                enviarSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
                enviarSMS.putExtra("sms_body", sMen);
                startActivity(enviarSMS);
            }
        });
    }
}
