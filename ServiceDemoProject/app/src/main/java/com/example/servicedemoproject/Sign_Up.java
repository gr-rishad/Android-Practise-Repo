package com.example.servicedemoproject;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Sign_Up extends AppCompatActivity  implements View.OnClickListener{


    String[] identity = {"National Card","Birthday Card","SSC Certificate","HSC Certificate","Passport"};
    String[] occupation={"Private Service","Govt. Service","Business","Startup Business","Doctor","Other"};

    private TextView loginText;
    private Button signUpBtnId;
    DatePickerDialog picker;
    static EditText userDateOfBirth;
    EditText userIdentityType,userOccupation;
    Spinner popupSpinner;
    LinearLayout signUpParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        signUpParent =(LinearLayout) findViewById(R.id.signUpParentId);



        loginText = (TextView) findViewById(R.id.logInTextId);
        loginText.setOnClickListener(this);
        signUpBtnId =(Button) findViewById(R.id.signUpButtonId);
        signUpBtnId.setOnClickListener(this);
        userDateOfBirth =(EditText) findViewById(R.id.userDateOfBirth);
        userDateOfBirth.setInputType(InputType.TYPE_NULL);
        userDateOfBirth.setOnClickListener(this);
        userOccupation =(EditText) findViewById(R.id.userOccupationId);
        userOccupation.setInputType(InputType.TYPE_NULL);
        userOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.spinner_popup, null);

                final PopupWindow popupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                popupSpinner = (Spinner)popupView.findViewById(R.id.popupspinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Sign_Up.this, android.R.layout.simple_spinner_item, occupation);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner.setAdapter(adapter);

                popupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        // Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString()+"Selected",Toast.LENGTH_SHORT).show();
                        String myStr=popupSpinner.getSelectedItem().toString();
                        userOccupation.setText(myStr);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });

                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {


                        popupWindow.dismiss();
                    }});
                popupWindow.showAsDropDown(userIdentityType, 50, -30);

            }
        });

        userIdentityType = (EditText) findViewById(R.id.userIdentityType);
        userIdentityType.setInputType(InputType.TYPE_NULL);
        userIdentityType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.spinner_popup, null);

                final PopupWindow popupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                popupSpinner = (Spinner)popupView.findViewById(R.id.popupspinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Sign_Up.this, android.R.layout.simple_spinner_item, identity);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner.setAdapter(adapter);

                popupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       // Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString()+"Selected",Toast.LENGTH_SHORT).show();
                        String myStr=popupSpinner.getSelectedItem().toString();
                        userIdentityType.setText(myStr);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {


                        popupWindow.dismiss();
                    }});
                popupWindow.showAsDropDown(userIdentityType, 50, -30);
            }
        });
    }
    public void showDate(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
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
            userDateOfBirth.setText(dayOfMonth+ "/"+(month+1)+"/"+year);
        }
    }




    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.logInTextId:
                intent = new Intent(Sign_Up.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.signUpButtonId:
                intent = new Intent(Sign_Up.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.userDateOfBirth:
                showDate(v);
                break;
        }
    }
}
