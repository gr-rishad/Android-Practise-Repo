package com.example.recyclercardgrid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mctx;
    private List<Book> mData;

    public RecyclerViewAdapter(Context mctx, List<Book> mData) {
        this.mctx = mctx;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mctx);
        view = mInflater.inflate(R.layout.cardview_item_book,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.tv_book_title.setText(mData.get(i).getTitle());
        myViewHolder.img_book_thumbnail.setImageResource(mData.get(i).getThumbnail());


        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // passing data to Book Activity
                Intent intent = new Intent(mctx,Book_Activity.class);
                intent.putExtra("BookTitle",mData.get(i).getTitle());
                intent.putExtra("Description",mData.get(i).getDescription());
                intent.putExtra("BookThumbnail",mData.get(i).getThumbnail());

                //start the activity
                mctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail=(ImageView) itemView.findViewById(R.id.book_img_id);
            cardView =(CardView)itemView.findViewById(R.id.cardViewId);

        }
    }
}
