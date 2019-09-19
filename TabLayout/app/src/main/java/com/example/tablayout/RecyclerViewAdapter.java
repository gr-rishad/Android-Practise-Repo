package com.example.tablayout;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Contact> mData;
    Dialog dialog;

    public RecyclerViewAdapter(Context mContext, List<Contact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v=LayoutInflater.from(mContext).inflate(R.layout.item_contact,viewGroup,false);
        final MyViewHolder vHolder= new MyViewHolder(v);

        // init Dialog

        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_contact);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name_tv = (TextView) dialog.findViewById(R.id.dialog_contact_name);
                TextView dialog_phone_tv = (TextView) dialog.findViewById(R.id.dilaog_phone_number);
                ImageView dialog_image_tv =(ImageView) dialog.findViewById(R.id.dialog_img);

                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_phone_tv.setText(mData.get(vHolder.getAdapterPosition()).getPhone());
                dialog_image_tv.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                Toast.makeText(mContext,"test Click"+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                dialog.show();
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mData.get(i).getName());
        myViewHolder.tv_phone.setText(mData.get(i).getPhone());
        myViewHolder.img.setImageResource(mData.get(i).getPhoto());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        LinearLayout item_contact;
        TextView tv_name;
        TextView tv_phone;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_contact = (LinearLayout) itemView.findViewById(R.id.contact_item);
            tv_name = (TextView) itemView.findViewById(R.id.name_contact);
            tv_phone=(TextView) itemView.findViewById(R.id.phone_number);
            img = (ImageView) itemView.findViewById(R.id.image_contact);
        }
    }
}
