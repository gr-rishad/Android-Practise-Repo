package com.example.servicedemoproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserServiceAdapter extends BaseAdapter {


    public ArrayList<UserServiceModel> productList;
    Activity activity;



    public UserServiceAdapter(Activity activity, ArrayList<UserServiceModel> productList) {
        super();
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView mSNo;
        TextView mProduct;
        TextView mCategory;
        TextView mPrice;

    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        UserServiceAdapter.ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.user_servicelist_row,null);
            holder = new UserServiceAdapter.ViewHolder();

            // holder.imagDetails=(ImageView) convertView.findViewById(R.id.sDetailsImageId);
            holder.mSNo = (TextView) convertView.findViewById(R.id.sNo);
            holder.mProduct = (TextView) convertView.findViewById(R.id.product);
            holder.mCategory = (TextView) convertView
                    .findViewById(R.id.category);
            holder.mPrice = (TextView) convertView.findViewById(R.id.price);
//            holder.imagDetails.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                 //   alertDialog();
//
//                }
//            });

            convertView.setTag(holder);
        } else {
            holder = (UserServiceAdapter.ViewHolder) convertView.getTag();
        }

        UserServiceModel item = productList.get(position);
        holder.mSNo.setText(item.getsNo().toString());
        holder.mProduct.setText(item.getCategory().toString());
        holder.mCategory.setText(item.getProduct().toString());

        holder.mPrice.setText(item.getPrice().toString());

        return convertView;

    }
}
