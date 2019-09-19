package com.example.mywishlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mywishlist.Data.DatabaseHandler;
import com.example.mywishlist.Model.MyWish;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText title,content;
    private Button saveButton;
    private DatabaseHandler dba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dba= new DatabaseHandler(MainActivity.this);


        title=(EditText) findViewById(R.id.titleId);
        content=(EditText) findViewById(R.id.wishId);
        saveButton=(Button) findViewById(R.id.buttonSaveId);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        saveToBD();

    }

    private void saveToBD() {

        MyWish wish= new MyWish();
        wish.setTitle(title.getText().toString().trim());
        wish.setContent(content.getText().toString().trim());

        dba.addWishes(wish);
        dba.close();

        //clear
        title.setText("");
        content.setText("");

        //Intent i = new Intent(MainActivity.this,WishDetailActivity.class);
       // startActivity(i);
    }
}
