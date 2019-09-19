package com.example.servicedemoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserService extends AppCompatActivity {
    private ArrayList<UserServiceModel> proList;
    Button btnGo;
    ImageView iVSeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_service);


        proList = new ArrayList<UserServiceModel>();
        ListView lview = (ListView) findViewById(R.id.listview);
        UserServiceAdapter adapter = new UserServiceAdapter(UserService.this,proList);
        lview.setAdapter(adapter);

        populateList();
        adapter.notifyDataSetChanged();

    }
    private void populateList() {

        UserServiceModel item1, item2, item3, item4, item5;

        item1 = new UserServiceModel("1","Electric Bill","KH","100");
        proList.add(item1);

        item2 = new UserServiceModel("2","Bath Cleaning","Per Hr.","500");
        proList.add(item2);;

        item3 = new UserServiceModel("3","Car Washing","Per Car","1000");
        proList.add(item3);

        item4 = new UserServiceModel("4","Computer Cleaning","Per Pc","300");
        proList.add(item4);

        item5 = new UserServiceModel("5","Kitchen Cleaning","Per Hr.","500");
        proList.add(item5);
    }
}
