package com.example.recyclercardgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> lstBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBook= new ArrayList<>();
        lstBook.add(new Book("War And Peace","Category Book","Description Book",R.drawable.book1));
        lstBook.add(new Book("Strong father, Strong Daughter","Category Book","Description Book",R.drawable.book2));
        lstBook.add(new Book("Javascript for web designers","Category Book","Description Book",R.drawable.book3));
        lstBook.add(new Book("The Time Will Be different","Category Book","Description Book",R.drawable.book4));
        lstBook.add(new Book("Body Language","Category Book","Description Book",R.drawable.book5));
        lstBook.add(new Book("The Magic","Category Book","Description Book",R.drawable.book6));
        lstBook.add(new Book("Sometimes Win, Sometimes Lose","Category Book","Description Book",R.drawable.book1));
        lstBook.add(new Book("War And Peace","Category Book","Description Book",R.drawable.book1));
        lstBook.add(new Book("Strong father, Strong Daughter","Category Book","Description Book",R.drawable.book2));
        lstBook.add(new Book("Javascript for web designers","Category Book","Description Book",R.drawable.book3));
        lstBook.add(new Book("The Time Will Be different","Category Book","Description Book",R.drawable.book4));
        lstBook.add(new Book("Body Language","Category Book","Description Book",R.drawable.book5));
        lstBook.add(new Book("The Magic","Category Book","Description Book",R.drawable.book6));
        lstBook.add(new Book("Sometimes Win, Sometimes Lose","Category Book","Description Book",R.drawable.book1));

        RecyclerView myRecyclerView= (RecyclerView) findViewById(R.id.recyclerviewId);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        myRecyclerView.setAdapter(myAdapter);
    }
}
