package com.example.eva2_2_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent inTel;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText=findViewById(R.id.edtTxtNum);

    }

    public void onClick(View v){
        String tel= "tel:"+ edtText.getText().toString();

        if(v.getId()==R.id.btnCall) {
            //(accion a ejecutar, datos para ejecutar)
            inTel = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
        }else{
            inTel = new Intent(Intent.ACTION_CALL, Uri.parse(tel));

        }


        startActivity(inTel);
    }

}
