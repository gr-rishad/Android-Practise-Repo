package com.example.servicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class spinner_popup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] countryNames;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_popup);

        countryNames = getResources().getStringArray(R.array.country);

        //Getting the instance of spinner and applyingOnItemSelectedListener it
       spinner = (Spinner) findViewById(R.id.spinnerId);
        //spin.setOnItemSelectedListener(this);


        //Creating ArrayAdapter instance having the bank name list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.samle_spinner_view,R.id.textViewSampleSpinnerId,countryNames);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),countryNames[position],Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
