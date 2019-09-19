package com.example.deleterecyclerviewitemthroughswipee;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.deleterecyclerviewitemthroughswipee.JWT.LoginActivity;

public class Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        //SetUp Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.details_toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_details,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==R.id.downloadId){

            SharedPreferences pref = getSharedPreferences("sessionPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed=pref.edit();
            String token= pref.getString("AuthToken","");
            //Toast.makeText(getApplicationContext(),"Token"+token,Toast.LENGTH_SHORT).show();
           // System.out.println(token);
            ed.clear();
            ed.commit();

            //Toast.makeText(getApplicationContext(),"Token"+token,Toast.LENGTH_SHORT).show();
            //String token= pref.getString("AuthToken","");
            //System.out.println(token);
            Intent i =new Intent(Details.this, LoginActivity.class);
           i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
           // finish();

//            System.out.println("finish activity");
//            System.out.println(token);

           // Toast.makeText(Details.this,"Download is Clicked",Toast.LENGTH_SHORT).show();
        } else if(item.getItemId()==R.id.deleteId){
            Toast.makeText(Details.this,"Delete is Clicked",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.messageId){
            Toast.makeText(Details.this,"Message is Clicked",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.shareId){
            Toast.makeText(Details.this,"Share is Clicked",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.settingsId){
            Toast.makeText(Details.this,"Settings is Clicked",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.helpId){
            Toast.makeText(Details.this,"Help is Clicked",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
