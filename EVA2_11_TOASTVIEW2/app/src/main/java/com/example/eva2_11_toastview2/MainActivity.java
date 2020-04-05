package com.example.eva2_11_toastview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void showCustomToast(View v){
        Toast customToast = makeCustomToast(this);
        customToast.show();
    }
    protected Toast makeCustomToast(Context context){
        LayoutInflater inflater =getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast,null);

        TextView text = layout.findViewById(R.id.toast_text);
        text.setText("This is a custom toast");

        Toast toast= new Toast(context);
        toast.setMargin(50,-50);
        toast.setDuration(Toast.LENGTH_LONG);

        toast.setView(layout);

        return toast;
    }
}
