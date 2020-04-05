package com.example.eva2_8_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyDataActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView lstRest;
    String[] Restaurantes={
            "McDonlads",
            "Burger King",
            "Peperoncino",
            "Dominos pizza",
            "Sushiko",
            "La bodeguita",
            "El papalote",
            "Dennys",
            "KFC",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        lstRest = findViewById(R.id.lstRestaurante);
        lstRest.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Restaurantes));

        lstRest.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inDatos= new Intent();
        inDatos.putExtra("datos",Restaurantes[position]);
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }

    public void onClick(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
