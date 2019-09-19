package com.example.servicedemoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    LinearLayout approvalList,serviceList,vendorList,vendorRegistration,userService,vendorDashboard,userRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        approvalList =(LinearLayout) findViewById(R.id.userApprovalListId);
        approvalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Toast.makeText(getApplicationContext(),"Approval List Clik",Toast.LENGTH_SHORT).show();

                        Intent intent;
                        intent = new Intent(Dashboard.this,Approval_List.class);
                        startActivity(intent);
            }
        });

        serviceList = (LinearLayout) findViewById(R.id.ServiceListId);
        serviceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(getApplicationContext(),"Approval List Clik",Toast.LENGTH_SHORT).show();

                Intent intent;
                intent = new Intent(Dashboard.this,Service_List.class);
                startActivity(intent);
            }
        });

        vendorList =(LinearLayout)findViewById(R.id.vendorSelectId);
        vendorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Dashboard.this,VendorSelect.class);
                startActivity(intent);
            }
        });
        vendorRegistration =(LinearLayout) findViewById(R.id.vendorRegistrationId);
        vendorRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent =new Intent(Dashboard.this,VendorRegistration.class);
                startActivity(intent);
            }
        });
        userService =(LinearLayout) findViewById(R.id.userServiceId);
        userService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent =new Intent(Dashboard.this,UserService.class);
                startActivity(intent);
            }
        });

        vendorDashboard =(LinearLayout) findViewById(R.id.vendorDashboardId);
        vendorDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Dashboard.this,VendorDashboard.class);
                startActivity(intent);
            }
        });

        userRating =(LinearLayout) findViewById(R.id.userRatingId);
        userRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent= new Intent(Dashboard.this,User_Rating.class);
                startActivity(intent);
            }
        });
    }
}
