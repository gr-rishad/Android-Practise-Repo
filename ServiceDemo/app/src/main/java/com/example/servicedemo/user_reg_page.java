package com.example.servicedemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class user_reg_page extends AppCompatActivity {

    DatePickerDialog picker;
    static EditText eDatePicker;
    EditText imageId;
    android.support.v7.app.AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg_page);

        eDatePicker = (EditText) findViewById(R.id.datePickerId);
        eDatePicker.setInputType(InputType.TYPE_NULL);
        eDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTruitondatePickerDialog(v);


            }

        });

        imageId =(EditText) findViewById(R.id.imageId);
       // imageId.setInputType(InputType.TYPE_NULL);
        imageId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
                alertDialog();
            }
        });

    }

    private void alertDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        v = getLayoutInflater().inflate(R.layout.activity_spinner__test_2,null);
        dialogBuilder.setView(v);

//        final Button sendCodeButtonId=(Button) v.findViewById(R.id.sendCodeButtonId);
//        sendCodeButtonId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (v==sendCodeButtonId){
//
//                    dialog.dismiss();
//                   // resetPassAlertDialog();
//                }
//            }
//        });

        dialog = dialogBuilder.create();
        dialog.show();



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
            DatePickerDialog dpd=new  DatePickerDialog(getActivity(),this,year,month,day);
            return dpd;

        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            // Do something with the date chosen by the user
            eDatePicker.setText(dayOfMonth+ "/"+(month+1)+"/"+year);
        }

    }
}
