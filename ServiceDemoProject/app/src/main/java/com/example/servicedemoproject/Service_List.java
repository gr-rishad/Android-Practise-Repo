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

public class Service_List extends AppCompatActivity {

    private ArrayList<ServiceListModel> proList;
    Button btnGo;
    ImageView iVSeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service__list);

        proList = new ArrayList<ServiceListModel>();
        ListView lview = (ListView) findViewById(R.id.listview);
        ServiceListViewAdapter adapter = new ServiceListViewAdapter(Service_List.this,proList);
        lview.setAdapter(adapter);

        populateList();
        adapter.notifyDataSetChanged();

    }

    private void populateList() {

        ServiceListModel item11, item2, item3, item4, item5;

        item11 = new ServiceListModel("1", "Bath Cleaning", "500", "Per Hour");
        proList.add(item11);

        item2 = new ServiceListModel("2", "Car Washing", "1000", "Per Car");
        proList.add(item2);

        item3 = new ServiceListModel("3", "Electric Bill", "300", "KH");
        proList.add(item3);

        item4 = new ServiceListModel("4", "Home Cleaning", "500", "Per Hour");
        proList.add(item4);

        item5 = new ServiceListModel("5", "Mobile Reparing", "1000", "Per Mobile");
        proList.add(item5);
    }

}
