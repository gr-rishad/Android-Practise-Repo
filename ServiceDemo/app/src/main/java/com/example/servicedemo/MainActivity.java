package com.example.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.logInId);
        textView1.setOnClickListener(this);
        btnSignUp =(Button) findViewById(R.id.signUpButtonId);
        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent  intent;
        switch (v.getId()){
            case R.id.logInId:
                intent = new Intent(MainActivity.this,user_reg_page.class);
                startActivity(intent);
                break;
            case R.id.signUpButtonId:
                intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
                break;
        }

    }
}
