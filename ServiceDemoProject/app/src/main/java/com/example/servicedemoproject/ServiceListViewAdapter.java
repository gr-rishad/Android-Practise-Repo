package com.example.servicedemoproject;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceListViewAdapter extends BaseAdapter {

    public ArrayList<ServiceListModel> productList;
    Activity activity;



    public ServiceListViewAdapter(Activity activity, ArrayList<ServiceListModel> productList) {
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
        ImageView imagDetails;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ServiceListViewAdapter.ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.service_listview_row,null);
            holder = new ServiceListViewAdapter.ViewHolder();

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
            holder = (ServiceListViewAdapter.ViewHolder) convertView.getTag();
        }

        ServiceListModel item = productList.get(position);
        holder.mSNo.setText(item.getsNo().toString());
        holder.mProduct.setText(item.getProduct().toString());
        holder.mCategory.setText(item.getCategory().toString());
        holder.mPrice.setText(item.getPrice().toString());

        return convertView;

    }

}
