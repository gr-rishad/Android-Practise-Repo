package com.example.listviewastablelayout;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainFragment extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        String[] serviceList={"Kitchen Cleaning","Bath Cleaning","Home Cleaning","Car Washing","Cloth Washing","Electric Bill","Computer Service"};

        listView = (ListView) findViewById(R.id.requestServiceListId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,serviceList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fragment fragment1;

        if(position==0){
            fragment1 = new Kitchen_Cleaning();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId,fragment1);
            fragmentTransaction.commit();

        }else if(position==1){
            fragment1 = new HomeCleaningFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId,fragment1);
            fragmentTransaction.commit();
        }else if(position==2){
            fragment1 = new BathCleaningFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentId,fragment1);
            fragmentTransaction.commit();
        }

    }
}
