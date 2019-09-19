package com.example.recyclercardgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Activity extends AppCompatActivity {

    private TextView title,description,category;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);

        title = (TextView) findViewById(R.id.bookTittleId);
        description =(TextView) findViewById(R.id.bookdescriptionId);
        category =(TextView) findViewById(R.id.bookCategoryId);
        img =(ImageView) findViewById(R.id.bookThumbnailId);

        //Receive data
        Intent intent = getIntent();
        String Ttl = intent.getExtras().getString("BookTitle");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("BookThumbnail");

         //Settings values
        title.setText(Ttl);
        description.setText(Description);
        img.setImageResource(image);




    }
}
