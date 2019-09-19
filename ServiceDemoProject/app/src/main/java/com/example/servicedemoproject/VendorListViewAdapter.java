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

public class VendorListViewAdapter extends BaseAdapter {

    public ArrayList<VendorDashboardModel> productList;
    Activity activity;

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    View v;

    public VendorListViewAdapter(Activity activity, ArrayList<VendorDashboardModel> productList) {
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
        TextView id,serviceId,contactId,locationId;

        ImageView imagDetails;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        VendorListViewAdapter.ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.vendor_dashboard_row,null);
            holder = new VendorListViewAdapter.ViewHolder();

            holder.imagDetails=(ImageView) convertView.findViewById(R.id.detailsImageId);
            holder.id = (TextView) convertView.findViewById(R.id.id);
            holder.serviceId = (TextView) convertView.findViewById(R.id.serviceNameId);
            holder.contactId = (TextView) convertView.findViewById(R.id.contactNoId);
            holder.locationId = (TextView) convertView.findViewById(R.id.locationId);
            holder.imagDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog();

                }
            });

            convertView.setTag(holder);
        } else {
            holder = (VendorListViewAdapter.ViewHolder) convertView.getTag();
        }

        VendorDashboardModel item = productList.get(position);
        holder.id.setText(item.getId().toString());
        holder.locationId.setText(item.getLocation().toString());
        holder.serviceId.setText(item.getServiceName().toString());
        holder.contactId.setText(item.getContactNumber().toString());

        return convertView;
    }
    private void alertDialog(){
        dialogBuilder = new AlertDialog.Builder(activity);
        v = activity.getLayoutInflater().inflate(R.layout.service_details_popup,null);
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
