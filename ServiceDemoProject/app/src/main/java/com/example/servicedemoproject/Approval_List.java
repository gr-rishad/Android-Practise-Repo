package com.example.servicedemoproject;

import android.content.Intent;
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

public class Approval_List extends AppCompatActivity {

    private ArrayList<ApprovalListModel> proList;
    ImageView iVSeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval__list);


        iVSeeDetails =(ImageView) findViewById(R.id.sDetailsImageId);


        proList = new ArrayList<ApprovalListModel>();
        ListView lview = (ListView) findViewById(R.id.listview);
        listViewAdapter adapter = new listViewAdapter(Approval_List.this,proList);
        lview.setAdapter(adapter);

        populateList();
        adapter.notifyDataSetChanged();

    }
    private void populateList() {

        ApprovalListModel item1, item2, item3, item4, item5;

        item1 = new ApprovalListModel("1","Shah","Golam","Business","Rabbani","12-12-12","0987654","National Card","0000000","l.email@gmail.com","M.Sc");
        proList.add(item1);

        item2 = new ApprovalListModel("2","Md","Saiful","Business","Islam","17-02-16","0176788","HSC","0176788","g.email@gmail.com","M.Sc");
        proList.add(item2);

        item3 = new ApprovalListModel("3","Md","Alif","Business","Ali","12-12-12","0987654","SSC Card","0000000","kk.email@gmail.com","M.Sc");
        proList.add(item3);

        item4 = new ApprovalListModel("4","Arifur","Rahman","Business","Arif","12-12-12","0987654","Birth Card","0000000","f.email@gmail.com","M.Sc");
        proList.add(item4);

        item5 = new ApprovalListModel("5","Apple","Arman","Business","Atik","12-12-12","0987654","National Card","0000000","l.email@gmail.com","M.Sc");
        proList.add(item5);
    }
}
