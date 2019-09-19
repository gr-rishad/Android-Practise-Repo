package com.example.deleterecyclerviewitemthroughswipee;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Form extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    String[] countryNames;
    Spinner spinner,spinner1;
    RelativeLayout relativeLayout;
     static EditText dateId;
     static TextView dateI;
     static AutoCompleteTextView autocmplt;
     EditText dateTimeEditText,dateTimeId,multipleEditText;
     AlertDialog.Builder dialog;
     AlertDialog dilog;
     View v;
     Button seeMultipleValue;

    int day, month,year,hour,minute;
    int dayFinal,monthFinal,yearFinal,hourFinal,minuteFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        countryNames =  getResources().getStringArray(R.array.country_names);
        spinner1 = (Spinner) findViewById(R.id.spinnerId);

//        TextView dateTime= (TextView) findViewById(R.id.dateTime);
//        String currentDateTime = DateFormat.getDateTimeInstance().format(new Date());
//        dateTime.setText(currentDateTime);

            multipleEditText =(EditText)findViewById(R.id.multipleEditId);
            seeMultipleValue=(Button) findViewById(R.id.seeMultipleValueId);
        seeMultipleValue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value=multipleEditText.getText().toString();
                    String[] valueStrings= value.split(",");
                    String[] result= new String[valueStrings.length];

                   // int result = floatStrings.length;
                    Toast.makeText(Form.this,"value:"+result.length,Toast.LENGTH_SHORT).show();
                    //String[] resultAll= new String[result];

                   int i;
                    for (  i=0;i<result.length;i++){
                        result[i]=String.valueOf(valueStrings[i]);

                    }
                    JSONArray a = new JSONArray(Arrays.asList(result));
                    Toast.makeText(Form.this,"value:"+ a,Toast.LENGTH_SHORT).show();

                }
            });

          dateTimeId =(EditText) findViewById(R.id.dateTimeId);
          dateTimeId.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Calendar c= Calendar.getInstance();
                  year=c.get(Calendar.YEAR);
                  month= c.get(Calendar.MONTH);
                  day=c.get(Calendar.DAY_OF_MONTH);

                  DatePickerDialog datePickerDialog= new DatePickerDialog(Form.this,Form.this,year,month,day);
                  datePickerDialog.show();
              }
          });



        autocmplt = (AutoCompleteTextView) findViewById(R.id.autocmpltId);
        ArrayAdapter<String> aapter = new ArrayAdapter<String>(this,R.layout.sample_spinner,R.id.spinner_categoryId,countryNames);
        autocmplt.setAdapter(aapter);
        autocmplt.setKeyListener(null);
        autocmplt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((AutoCompleteTextView)v).showDropDown();
                return false;
            }
        });



        //relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayoutId);
        dateId=(EditText) findViewById(R.id.dateEditId);
        dateId.setInputType(InputType.TYPE_NULL);
        dateId.requestFocus();
        dateId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v==dateId){
                    showDate(v);
                }

            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_spinner,R.id.spinner_categoryId,countryNames);
        spinner1.setAdapter(aapter);


        // date time together
        dateTimeEditText =(EditText) findViewById(R.id.dateTimeEditId);
        dateTimeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create dialog
               // dialog = new AlertDialog.Builder(this);
                alertDialog();

            }
        });


    }

    private void alertDialog(){
        dialog =new AlertDialog.Builder(this);
        v= getLayoutInflater().inflate(R.layout.date_time_picker,null);
        dialog.setView(v);

        dilog=dialog.create();
        dilog.show();

        //Grab widget instance
        //final v.DateTimePicker

    }

    public void showDate(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        yearFinal= year;
        monthFinal=month+1;
        dayFinal= dayOfMonth;

        Calendar c = Calendar.getInstance();
        hour= c.get(android.icu.util.Calendar.HOUR_OF_DAY);
        minute =c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog= new TimePickerDialog(Form.this,Form.this,hour,minute, false);
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        minuteFinal=minute;
        hourFinal=hourOfDay;

        dateTimeId.setText(yearFinal+"-"+monthFinal+"-"+dayFinal+"T"+hourFinal+":"+minuteFinal);

    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            //Create a new instance of DatePickerDialog and return it
            DatePickerDialog dpd = new DatePickerDialog(getActivity(),  this, year, month, day);
            return dpd;

        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            // Do something with the date chosen by the user
            dateId.setText(dayOfMonth+ "/"+(month+1)+"/"+year);
        }
    }
}
