package com.example.listviewastablelayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class date_picker extends AppCompatActivity {

    DatePickerDialog picker;
    static EditText eDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        eDatePicker = (EditText) findViewById(R.id.datePickerId);
        eDatePicker.setInputType(InputType.TYPE_NULL);
        eDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTruitondatePickerDialog(v);


            }

        });

    }
    public void showTruitondatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            // Use the current date as the default date in the picker
            final Calendar c= Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);

            //Create a new instance of DatePickerDialog and return it
            DatePickerDialog dpd=new  DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);
            return dpd;

        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            // Do something with the date chosen by the user
            eDatePicker.setText(dayOfMonth+ "/"+(month+1)+"/"+year);
        }
    }
}