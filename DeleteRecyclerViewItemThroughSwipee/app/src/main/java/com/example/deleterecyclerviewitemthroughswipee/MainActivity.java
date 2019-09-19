package com.example.deleterecyclerviewitemthroughswipee;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.deleterecyclerviewitemthroughswipee.Adapter.CardListAdapter;
import com.example.deleterecyclerviewitemthroughswipee.Helper.RecyclerItemTouchHelper;
import com.example.deleterecyclerviewitemthroughswipee.Helper.RecyclerItemTouchHelperListener;
import com.example.deleterecyclerviewitemthroughswipee.Model.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {

    private RecyclerView recyclerView;
    private List<Item> list;
    private CardListAdapter adapter;
    private LinearLayout rootLayout;


    private final String JSON_URL ="https://api.androidhive.info/json/menu.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //SetUp Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EDMT Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView =(RecyclerView) findViewById(R.id.recycler_viewId);
        rootLayout =(LinearLayout) findViewById(R.id.rootLayout);

        list = new ArrayList<>();




        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack=
                new RecyclerItemTouchHelper(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT,this);
                new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recyclerView);







        // request API
        jsonCall();

    }

    private void jsonCall() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               // list.clear(); // remove all item
               // adapter.notifyDataSetChanged();

                JSONObject jsonObject = null;
                for(int i=0;i<response.length();i++){
                    try {
                        jsonObject = response.getJSONObject(i);

                        Item itemList =new Item();
                        itemList.setName(jsonObject.getString("name"));
                        itemList.setDescription(jsonObject.getString("description"));
                        itemList.setPrice(jsonObject.getString("price"));
                        itemList.setThumbnail(jsonObject.getString("thumbnail"));

                        list.add(itemList);




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

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setUpRecyclerView(List<Item> list) {

        adapter = new CardListAdapter(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {



        if(direction==ItemTouchHelper.RIGHT){
           // Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();
            if(viewHolder instanceof CardListAdapter.MyViewHolder){
                String name= list.get(viewHolder.getAdapterPosition()).getName();
                final Item deletedItem= list.get(viewHolder.getAdapterPosition());
                final int deleteIndex = viewHolder.getAdapterPosition();

                adapter.removeItem(deleteIndex);

                Snackbar snackbar = Snackbar.make(rootLayout,name+"Remove from Cart !",Snackbar.LENGTH_SHORT);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adapter.restoreItem(deletedItem,deleteIndex);
                    }
                });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
        }else if(direction==ItemTouchHelper.LEFT) {

//                final int getItem=viewHolder.getAdapterPosition();
//                adapter.getItemAt(getItem);
            Toast.makeText(MainActivity.this,"left"+position,Toast.LENGTH_SHORT).show();

finish();

            Intent i;
            i= new Intent(MainActivity.this,CheckActivity.class);
            startActivity(i);
            final Item deletedItem= list.get(viewHolder.getAdapterPosition());
            final int deleteIndex = viewHolder.getAdapterPosition();

           //adapter.removeItem(deleteIndex);



        }


    }
}
