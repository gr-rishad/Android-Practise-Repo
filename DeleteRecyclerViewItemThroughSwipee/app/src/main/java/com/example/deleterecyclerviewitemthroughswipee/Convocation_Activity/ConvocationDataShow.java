package com.example.deleterecyclerviewitemthroughswipee.Convocation_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.deleterecyclerviewitemthroughswipee.ConModel.ConvocationModel;
import com.example.deleterecyclerviewitemthroughswipee.ConvocationAdapter.ConvocationModelAdapter;
import com.example.deleterecyclerviewitemthroughswipee.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConvocationDataShow extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<ConvocationModel> list;
    private RequestQueue requestQueue;
    private ConvocationModelAdapter adapter;

    private String URL="http://convocation.diu.edu.bd/api/document-clearance-notification?key=3d6cea77-5815-4dc8-9adb-89eeea18f58d&clientSecret=diuAdminAndroidApp&employeeId=710000640&roleId=1";
    private JsonArrayRequest request;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convocation_data_show);

        //toolbar
        Toolbar toolbar=(Toolbar) findViewById(R.id.con_toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Convocation App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=(RecyclerView) findViewById(R.id.con_recyclerViewId);
        list=new ArrayList<>();

        //request for API
        jsonCall();

    }

    private void jsonCall(){

        request = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for (int i=0;i<response.length();i++){
                    try {
                        jsonObject=response.getJSONObject(i);
                        ConvocationModel cm=new ConvocationModel();
                        cm.setStudentId(jsonObject.getString("studentId"));
                        cm.setProgShortName(jsonObject.getString("progShortName"));
                        cm.setCampusName(jsonObject.getString("campusName"));
                        cm.setShift(jsonObject.getString("shift"));

                        list.add(cm);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                setUpRecyclerView(list);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
    private void setUpRecyclerView(List<ConvocationModel> list){

        adapter= new ConvocationModelAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
