package com.example.listviewastablelayout;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {


    public ArrayList<Model> productList;
    Activity activity;

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    View v;


    public listviewAdapter(Activity activity, ArrayList<Model> productList) {
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

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row,null);
            holder = new ViewHolder();

            holder.imagDetails=(ImageView) convertView.findViewById(R.id.sDetailsImageId);
            holder.mSNo = (TextView) convertView.findViewById(R.id.sNo);
            holder.mProduct = (TextView) convertView.findViewById(R.id.product);
            holder.mCategory = (TextView) convertView
                    .findViewById(R.id.category);
            holder.mPrice = (TextView) convertView.findViewById(R.id.price);
            holder.imagDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog();

                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Model item = productList.get(position);
        holder.mSNo.setText(item.getsNo().toString());
        holder.mProduct.setText(item.getProduct().toString());
        holder.mCategory.setText(item.getCategory().toString());
        holder.mPrice.setText(item.getPrice().toString());

        return convertView;
    }
    private void alertDialog(){
        dialogBuilder = new AlertDialog.Builder(activity);
        v = activity.getLayoutInflater().inflate(R.layout.approval_popup,null);
        dialogBuilder.setView(v);

        final Button approve=(Button) v.findViewById(R.id.btnApproveId);
        final Button deny=(Button) v.findViewById(R.id.btnDenyId);
        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (v==sendCodeButtonId){
//
//                    dialog.dismiss();
//                    resetPassAlertDialog();
//                }
//            }
//        });

        dialog = dialogBuilder.create();
        dialog.show();
    }




}
