package com.example.deleterecyclerviewitemthroughswipee.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.deleterecyclerviewitemthroughswipee.Details;
import com.example.deleterecyclerviewitemthroughswipee.Model.Item;
import com.example.deleterecyclerviewitemthroughswipee.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CardListAdapter  extends RecyclerView.Adapter<CardListAdapter.MyViewHolder> {

    private Context context;
    private List<Item> list;

    List<Item> itemPendingApproval= new ArrayList<>();

    public CardListAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card_list_item,viewGroup,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Details.class);
                context.startActivity(i);
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Item item= list.get(i);
        myViewHolder.name.setText(item.getName());
        myViewHolder.description.setText(item.getDescription());
        myViewHolder.price.setText(item.getPrice());
        Picasso.get()
                .load(item.getThumbnail())
                .into(myViewHolder.thumbnail);

    }

    @Override

    public int getItemCount() {
        return list.size();
    }

    public void removeItem(int i){
        list.remove(i);
        notifyItemRemoved(i);
    }

    public void restoreItem(Item item,int i){
        list.add(i,item);
        notifyItemInserted(i);

    }
    public Item getItemAt(int i){
       return list.get(i);

    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name,description,price;
        public ImageView thumbnail;
        public RelativeLayout viewBackground,viewForeground,vBack;
        FrameLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container =itemView.findViewById(R.id.container);
           name = itemView.findViewById(R.id.nameId);
           description = itemView.findViewById(R.id.descriptionId);
           price = itemView.findViewById(R.id.priceId);
           thumbnail = itemView.findViewById(R.id.thumbnailId);
           //viewBackground= itemView.findViewById(R.id.view_backgroundId);
           viewForeground = itemView.findViewById(R.id.view_foreground);
         //  vBack = itemView.findViewById(R.id.view_backId);
        }
    }
}
