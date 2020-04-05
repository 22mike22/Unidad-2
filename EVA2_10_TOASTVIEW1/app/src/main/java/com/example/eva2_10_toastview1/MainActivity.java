package com.example.eva2_10_toastview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText txtXCoordinate;
    EditText txtYCoordinate;
    TextView txtCaption;
    Button btnShowToast;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// bind GUI and Java controls
        txtCaption = (TextView) findViewById(R.id.txtCaption);
        txtXCoordinate = (EditText) findViewById(R.id.txtXCoordinate);
        txtYCoordinate = (EditText) findViewById(R.id.txtYCoordinate);
        btnShowToast = (Button) findViewById(R.id.btnShowToast);
// find screen-size and density(dpi)
        int dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        int width= Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        txtCaption.append("\n Screen size= " + width + "x" + height
                +" Density=" + dpi + "dpi");
        // show toast centered around selected X,Y coordinates
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast myToast = Toast.makeText(getApplicationContext(),
                            "Here", Toast.LENGTH_LONG);
                    myToast.setGravity(
                            Gravity.CENTER,
                            Integer.valueOf(txtXCoordinate.getText().toString()),
                            Integer.valueOf(txtYCoordinate.getText().toString()));
                    myToast.show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();

                }
            }
        });

    }// onCreate
}
