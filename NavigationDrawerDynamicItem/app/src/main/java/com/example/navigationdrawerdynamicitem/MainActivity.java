package com.example.navigationdrawerdynamicitem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






       // navigationView.setNavigationItemSelectedListener(this);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        displayMenu();
    }

    private void displayMenu(){
        NavigationView navigationView= findViewById(R.id.navigationId);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        toggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Menu menu= navigationView.getMenu();
        menu.add("Home").setOnMenuItemClickListener(this);
        menu.add("Profile");
        menu.add("Settings");


       final String aa= menu.toString();
        System.out.println(aa);
        menu.add(aa).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent= new Intent(MainActivity.this,CheckActivity.class);
                intent.putExtra("Value",aa);
                startActivity(intent);
                return false;
            }
        });

        MenuModel menuModel= new MenuModel();
        for (String m:menuModel.findAll()){
            menu.add(m);
        }



        drawerLayout.closeDrawers();


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        if (menuItem.getItemId()==1){
//
//            Intent intent= new Intent(MainActivity.this,CheckActivity.class);
//            intent.putExtra("Value","It's Home");
//            startActivity(intent);
//
//        }
//        return false;
//    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId()==0){
            Intent intent= new Intent(MainActivity.this,CheckActivity.class);
            intent.putExtra("Value","It's Home");
            startActivity(intent);
        }
        return false;
    }
}
