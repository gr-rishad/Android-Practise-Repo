package com.example.servicedemoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class VendorDashboard extends AppCompatActivity {

    private ArrayList<VendorDashboardModel> proList;
    ImageView iVSeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_dashboard);

        iVSeeDetails =(ImageView) findViewById(R.id.detailsImageId);


        proList = new ArrayList<VendorDashboardModel>();
        ListView lview = (ListView) findViewById(R.id.listview);
        VendorListViewAdapter adapter = new VendorListViewAdapter(VendorDashboard.this,proList);
        lview.setAdapter(adapter);

        populateList();
        adapter.notifyDataSetChanged();
    }

    private void populateList() {

        VendorDashboardModel item1, item2, item3;

        item1 = new VendorDashboardModel("1","Electric Bill","01654327","Dhanmondi");
        proList.add(item1);

        item2 = new VendorDashboardModel("2","Electric Bill" ,"01654327","Dhanmondi");
        proList.add(item2);

        item3 = new VendorDashboardModel("3","Electric Bill","01654327","Dhanmondi");
        proList.add(item3);


    }
}
