package com.example.navigationdrawerdynamicitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


        Intent intent= getIntent();
        String value=intent.getStringExtra("Value");
        TextView textView=findViewById(R.id.chkValueId);
        textView.setText(value);
    }
}
