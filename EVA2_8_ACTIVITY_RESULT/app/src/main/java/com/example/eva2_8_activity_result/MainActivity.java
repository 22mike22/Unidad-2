package com.example.eva2_8_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent inLanzar, inSelContactos, inVideo, inAudio, inImagen;
    final int Restaurante = 1000;
    final int contactos = 1001;
    final int audio = 1002;
    final int video = 1003;
    final int imagen = 1004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        inLanzar = new Intent(this, MyDataActivity.class);
        startActivityForResult(inLanzar, Restaurante);
    }

    public void onClickContacts(View v){
        inSelContactos = new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(inSelContactos,contactos);
    }

    public void onClickAudio(View v){
        inAudio = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(inAudio,audio);
    }

    public void onClickImagen(View v){
        inImagen = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(inImagen,imagen);
    }

    public void onClickVideo(View v){
        inVideo = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(inVideo,video);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){ //requestCode es el codigo con el que se lanzo startActivityForResult
            case Restaurante: //en este caso que pasaria si el requestCode sea igual a Restaurante
                if(resultCode == Activity.RESULT_OK){
                    //que accion se va a ejecutar con los datos que regresa la actividad
                    Toast.makeText(this,data.getStringExtra("datos"),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"No elegiste nada",Toast.LENGTH_SHORT).show();
                }
                break;
            case contactos:
                if(resultCode==Activity.RESULT_OK){
                    String sCont = data.getDataString();
                    Log.wtf("CONTACTO",sCont);
                    Toast.makeText(this,sCont,Toast.LENGTH_SHORT).show();
                }
                break;
            case imagen:
                if(resultCode == Activity.RESULT_OK){
                    String sIma = data.getDataString();
                    Log.wtf("Imagen",sIma);
                    Toast.makeText(this, sIma,Toast.LENGTH_SHORT).show();
                }
                break;
            case audio:
                if (resultCode == Activity.RESULT_OK){
                    String sAudio = data.getDataString();
                    Log.wtf("audio",sAudio);
                    Toast.makeText(this,sAudio,Toast.LENGTH_SHORT).show();
                }
                break;
            case video:
                if (resultCode==Activity.RESULT_OK){
                    String sVideo = data.getDataString();
                    Log.wtf("video", sVideo);
                    Toast.makeText(this,sVideo,Toast.LENGTH_SHORT).show();
                }
        }
    }
}
