package com.example.deleterecyclerviewitemthroughswipee;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.deleterecyclerviewitemthroughswipee.Convocation_Activity.ConvocationDataShow;
import com.example.deleterecyclerviewitemthroughswipee.JWT.LoginActivity;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    TextView Proname,designationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //SetUp Toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EDMT Cart");

        NavigationView navigationView =(NavigationView) findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navView = (NavigationView) findViewById(R.id.navigationId);
        View hView = navigationView.getHeaderView(0);
         Proname = (TextView)hView.findViewById(R.id.headerNameId);
         designationText=(TextView)hView.findViewById(R.id.designationId);





//       // Proname=(TextView) findViewById(R.id.headerNameId);
        Intent intent= this.getIntent();
        if (intent !=null){
            String employeeName= intent.getExtras().getString("employeeName");
            String designation= intent.getExtras().getString("designation");
           // System.out.println(uname);
           Proname.setText(employeeName);
            designationText.setText(designation);

        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Intent i;
        if (menuItem.getItemId()== R.id.homeMenuId){
            i= new Intent(this,MainActivity.class);
            startActivity(i);
        }
        else if(menuItem.getItemId()==R.id.profileMenuId){
            i = new Intent(this,Form.class);
            startActivity(i);
        }else if(menuItem.getItemId()==R.id.chatMenuId){
            i = new Intent(this, ConvocationDataShow.class);
            startActivity(i);
        }else if(menuItem.getItemId()==R.id.logoutMenuId){
            i = new Intent(this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        return false;
    }
}
