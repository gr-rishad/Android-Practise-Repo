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

public class listViewAdapter extends BaseAdapter {

    public ArrayList<ApprovalListModel> productList;
    Activity activity;

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    View v;


    public listViewAdapter(Activity activity, ArrayList<ApprovalListModel> productList) {
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
        TextView id,firstName,lastName,middleName,dateOfBirth,identitynumber,idetityType,phoneNumber,email,lastDegree,occupution;

        ImageView imagDetails;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        //ViewHolder holder;
        ViewHolder holder;


        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row,null);
            holder = new ViewHolder();

            holder.imagDetails=(ImageView) convertView.findViewById(R.id.sDetailsImageId);
            holder.id = (TextView) convertView.findViewById(R.id.id);
            holder.firstName = (TextView) convertView.findViewById(R.id.firstName);
            holder.middleName = (TextView) convertView.findViewById(R.id.middleName);
            holder.lastName = (TextView) convertView.findViewById(R.id.lastName);
           holder.dateOfBirth = (TextView) convertView.findViewById(R.id.dateOfBirth);
            holder.identitynumber = (TextView) convertView.findViewById(R.id.identityNumber);
            //holder.occupution =(TextView) convertView.findViewById(R.id.userOccupationId);
            holder.idetityType = (TextView) convertView.findViewById(R.id.identityType);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
            holder.email = (TextView) convertView.findViewById(R.id.email);
            holder.lastDegree = (TextView) convertView.findViewById(R.id.lastDegree);
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

        ApprovalListModel item = productList.get(position);
        holder.id.setText(item.getId().toString());
        holder.firstName.setText(item.getFirstName().toString());
        holder.middleName.setText(item.getMiddleName().toString());
        holder.lastName.setText(item.getLastName().toString());
        holder.phoneNumber.setText(item.getPhoneNumber().toString());
        holder.email.setText(item.getEmail().toString());
       // holder.occupution.setText(item.getOccupation().toString());
        holder.idetityType.setText(item.getIdentityType().toString());
        holder.identitynumber.setText(item.getIdentityNumber().toString());
        holder.dateOfBirth.setText(item.getDateOfBirth().toString());




        holder.lastDegree.setText(item.getLastDegree().toString());

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
