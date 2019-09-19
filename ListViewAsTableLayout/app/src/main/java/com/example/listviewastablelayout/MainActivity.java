package com.example.listviewastablelayout;

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

public class MainActivity extends AppCompatActivity {


    private ArrayList<Model> proList;
    Button btnGo;
    ImageView iVSeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo =(Button) findViewById(R.id.btnGo);
        iVSeeDetails =(ImageView) findViewById(R.id.sDetailsImageId);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                switch (v.getId()){
                    case R.id.btnGo:
                        intent = new Intent(MainActivity.this,Spinner_PopUp.class);
                        startActivity(intent);
                        break;
                }

            }
        });


        proList = new ArrayList<Model>();
        ListView lview = (ListView) findViewById(R.id.listview);
        listviewAdapter adapter = new listviewAdapter(MainActivity.this,proList);
        lview.setAdapter(adapter);

        populateList();
        adapter.notifyDataSetChanged();
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String sno= ((TextView)view.findViewById(R.id.sNo)).getText().toString();
                String product= ((TextView)view.findViewById(R.id.product)).getText().toString();
                String category= ((TextView)view.findViewById(R.id.category)).getText().toString();
                String price= ((TextView)view.findViewById(R.id.price)).getText().toString();

                Toast.makeText(getApplicationContext(),
                        "S no : " + sno +"\n"
                                +"Product : " + product +"\n"
                                +"Category : " +category +"\n"
                                +"Price : " +price, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void populateList() {

        Model item1, item2, item3, item4, item5;

        item1 = new Model("1", "Apple (Northern Spy)", "Fruits", "₹. 200");
        proList.add(item1);

        item2 = new Model("2", "Orange (Sunkist navel)", "Fruits", "₹. 100");
        proList.add(item2);

        item3 = new Model("3", "Tomato", "Vegetable", "₹. 50");
        proList.add(item3);

        item4 = new Model("4", "Carrot", "Vegetable", "₹. 80");
        proList.add(item4);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        proList.add(item5);
    }
}
