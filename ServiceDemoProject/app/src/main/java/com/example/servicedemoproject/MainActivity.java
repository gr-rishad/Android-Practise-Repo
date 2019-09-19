package com.example.servicedemoproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView forgetPasswordText;
    private Button signInBtn;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn =(Button) findViewById(R.id.signInButtonId);
        signInBtn.setOnClickListener(this);

        forgetPasswordText =(TextView) findViewById(R.id.forgetPasswordId);
        forgetPasswordText.setOnClickListener(this);
    }
    private void alertDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        v = getLayoutInflater().inflate(R.layout.forget_password_popup,null);
        dialogBuilder.setView(v);

        final Button sendCodeButtonId=(Button) v.findViewById(R.id.sendCodeButtonId);
        sendCodeButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v==sendCodeButtonId){

                    dialog.dismiss();
                    resetPassAlertDialog();
                }
            }
        });

        dialog = dialogBuilder.create();
        dialog.show();



    }
    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()){
            case R.id.signInButtonId:
                intent = new Intent(MainActivity.this,
                        Dashboard.class);
                startActivity(intent);
                break;
            case R.id.forgetPasswordId:
                alertDialog();
                break;
        }

    }
    private void resetPassAlertDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        v = getLayoutInflater().inflate(R.layout.reset_password_popup,null);
        dialogBuilder.setView(v);
        dialog = dialogBuilder.create();
        dialog.show();

        final Button confirmButtonId = (Button) v.findViewById(R.id.confirmButtonId);

        confirmButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

    }
}
