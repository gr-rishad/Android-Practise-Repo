package com.example.volleyparse.Activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.volleyparse.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        // hide the default actionBar
        getSupportActionBar().hide();

        // Recieve Data

        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String category = getIntent().getExtras().getString("anime_category");
        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode");
        String rating= getIntent().getExtras().getString("anime_rating");
        String image_url = getIntent().getExtras().getString("anime_img");


        // initial views
        CollapsingToolbarLayout collapsingToolbarLayout= findViewById(R.id.collapsingToolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name= findViewById(R.id.aa_anime_name);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_category = findViewById(R.id.aa_category);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView img= findViewById(R.id.aa_thumbnail);

        //set value to each view

        tv_name.setText(name);
        tv_description.setText(description);
        tv_studio.setText(studio);
        tv_category.setText(category);
        tv_rating.setText(rating);
        tv_studio.setText(studio);

        //set image using Glide
        Glide.with(this).load(image_url).into(img);



    }
}
