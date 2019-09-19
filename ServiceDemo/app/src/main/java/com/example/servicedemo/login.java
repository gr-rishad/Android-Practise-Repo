package com.example.servicedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity  implements View.OnClickListener{

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    private Button sendButtonId,signInButton;
    TextView forgetPasswordId;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgetPasswordId=(TextView) findViewById(R.id.forgetPasswordId);
        signInButton = (Button) findViewById(R.id.signInButtonId);

        forgetPasswordId.setOnClickListener(this);
        signInButton.setOnClickListener(this);

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
        if(v==forgetPasswordId){
            alertDialog();

        }else if(v==signInButton){

            //callXml();
           // return true;
            startActivity(new Intent(login.this,DashBoard.class));
        }

    }

    private void resetPassAlertDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        v = getLayoutInflater().inflate(R.layout.resert_password_popup,null);
        dialogBuilder.setView(v);
        dialog = dialogBuilder.create();
        dialog.show();

        final Button confirmButtonId = (Button) v.findViewById(R.id.confirmButtonId);

        confirmButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                startActivity(new Intent(login.this,login.class));
            }
        });

    }

    public boolean callXml(){
        getLayoutInflater().inflate(R.layout.dashboard_modern,null);
        return true;
    }
}

