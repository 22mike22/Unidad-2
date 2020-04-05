package com.example.eva2_9_alertadialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

//import android.app.AlertDialog;
import android.app.Dialog;
//import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtMsg;
    Button btnCustomDialog, btnAlertDialog, btnDialogFragment;
    Context activityContext;
    String msg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityContext = this;

        txtMsg= findViewById(R.id.txtMsg);
        btnAlertDialog = findViewById(R.id.btn_alert_dialog1);
        btnCustomDialog=findViewById(R.id.btn_custom_dialog);
        btnDialogFragment=findViewById(R.id.btn_alert_dialog2);

        btnDialogFragment.setOnClickListener(this);
        btnCustomDialog.setOnClickListener(this);
        btnAlertDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnAlertDialog.getId()){
            showMyAlertDialog(this);
        }
        if(v.getId()==btnCustomDialog.getId()){
            showCustomDialogBox();
        }
        if(v.getId()==btnDialogFragment.getId()){
            showMyAlertDialogFragment(this);
        }
    }
    private void showMyAlertDialog(MainActivity mainActivity) {
        new AlertDialog.Builder(mainActivity)
                .setTitle("The Terminator 2000")
                .setMessage("Are you sure that you want to quit?")
                .setIcon(R.drawable.casa)
// set three option buttons
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
// actions serving "YES" button go here
                                msg = "YES " + Integer.toString(whichButton);
                                txtMsg.setText(msg);
                            }
                        })// setPositiveButton
    .setNeutralButton("Cancel",
                              new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog,
        int whichButton) {
// actions serving "CANCEL" button go here
            msg = "CANCEL " + Integer.toString(whichButton);
            txtMsg.setText(msg);
        }// OnClick
    })// setNeutralButton
            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
// actions serving "NO" button go here
            msg = "NO " + Integer.toString(whichButton);
            txtMsg.setText(msg);
        }
    })// setNegativeButton
            .create()
.show();
}//
    private void showCustomDialogBox() {
        final Dialog customDialog = new Dialog(activityContext);
        customDialog.setTitle("Custom Dialog Title");
// match customDialog with custom dialog layout
        customDialog.setContentView(R.layout.custom_dialog_layout);
        ((TextView) customDialog.findViewById(R.id.sd_textView1))
                .setText("\nMessage line1\nMessage line2\n"
                        +"Dismiss: Back btn, Close, or touch outside");
        final EditText sd_txtInputData = (EditText) customDialog

                .findViewById(R.id.sd_editText1);

        ((Button) customDialog.findViewById(R.id.sd_btnClose))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtMsg.setText(sd_txtInputData.getText().toString());
                        customDialog.dismiss();
                    }
                });
        customDialog.show();
    }
    private void showMyAlertDialogFragment(MainActivity mainActivity) {
        DialogFragment dialogFragment = MyAlertDialogFragment.newInstance(R.string.title);
        dialogFragment.show(getSupportFragmentManager(), "TAG_MYDIALOGFRAGMENT1");
    }
    public void doPositiveClick(Date time) {
        txtMsg.setText("POSITIVE - DialogFragment picked @ " + time);
    }
    public void doNegativeClick(Date time) {
        txtMsg.setText("NEGATIVE - DialogFragment picked @ " + time);
    }
    public void doNeutralClick(Date time) {
        txtMsg.setText("NEUTRAL - DialogFragment picked @ " + time);
    }
}

