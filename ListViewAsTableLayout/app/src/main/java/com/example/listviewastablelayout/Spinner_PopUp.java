package com.example.listviewastablelayout;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_PopUp extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    String[] Company = {"Apple","Genpack","Microsoft","HP","HCL","Ericsson"};
    Spinner popupSpinner;
    EditText btnOpenPopup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner__pop_up);



        btnOpenPopup = (EditText) findViewById(R.id.openpopup);
        btnOpenPopup.setInputType(InputType.TYPE_NULL);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {



                LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popup, null);

                final PopupWindow popupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                 popupSpinner = (Spinner)popupView.findViewById(R.id.popupspinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Spinner_PopUp.this, android.R.layout.simple_spinner_item, Company);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                popupSpinner.setAdapter(adapter);

                popupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString()+"Selected",Toast.LENGTH_SHORT).show();
                        String myStr=popupSpinner.getSelectedItem().toString();
                        btnOpenPopup.setText(myStr);

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
                popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString()+"Selected",Toast.LENGTH_SHORT).show();
        String myStr=popupSpinner.getSelectedItem().toString();
        btnOpenPopup.setText(myStr);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
