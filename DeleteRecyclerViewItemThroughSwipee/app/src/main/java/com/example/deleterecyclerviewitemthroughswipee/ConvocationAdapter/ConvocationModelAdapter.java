package com.example.deleterecyclerviewitemthroughswipee.ConvocationAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deleterecyclerviewitemthroughswipee.ConModel.ConvocationModel;
import com.example.deleterecyclerviewitemthroughswipee.R;

import java.util.List;

public class ConvocationModelAdapter  extends RecyclerView.Adapter<ConvocationModelAdapter.MyViewHolder> {

    private Context context;
    private List<ConvocationModel> list;


    public ConvocationModelAdapter(Context context, List<ConvocationModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
       View view= layoutInflater.inflate(R.layout.con_recyclerview_list_item,viewGroup,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        ConvocationModel  item=list.get(i);
        myViewHolder.studentId.setText(item.getStudentId());
        myViewHolder.proName.setText(item.getProgShortName());
        myViewHolder.campus.setText(item.getCampusName());
        myViewHolder.shift.setText(item.getShift());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView studentId,proName,campus,shift;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            studentId=itemView.findViewById(R.id.studentId);
            proName=itemView.findViewById(R.id.proNameId);
            campus=itemView.findViewById(R.id.campusId);
            shift=itemView.findViewById(R.id.shiftId);
        }
    }
}
