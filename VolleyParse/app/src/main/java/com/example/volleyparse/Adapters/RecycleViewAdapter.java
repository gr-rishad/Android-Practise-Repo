package com.example.volleyparse.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.volleyparse.Activities.AnimeActivity;
import com.example.volleyparse.Model.Anime;
import com.example.volleyparse.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter  extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> implements Filterable {

    private Context mContext;
    private List<Anime> mData;
    private List<Anime> searchList;
    RequestOptions option;

    public RecycleViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.searchList=mData;

        // Request option for Glide
        option= new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        View view  = layoutInflater.inflate(R.layout.anime_row_item,viewGroup,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);

            }
        });



        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mData.get(i).getName());
        myViewHolder.tv_rating.setText(mData.get(i).getRating());
        myViewHolder.tv_studio.setText(mData.get(i).getStudio());
        myViewHolder.tv_category.setText(mData.get(i).getCategorie());


        // Load Image from the internet and set it into ImageView using Glide
        Glide.with(mContext).load(mData.get(i).getImage_url()).apply(option).into(myViewHolder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                List<Anime> filterResult=null;

                if (constraint.length() ==0){
                    filterResult=mData;
                }else {


                    filterResult= getFilteredResult(constraint.toString().toLowerCase());

                  //  System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                }
                FilterResults results = new FilterResults();
                results.values=filterResult;


                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

               // mData.clear();
                searchList= (List<Anime>) results.values;
                notifyDataSetChanged();
            }
        };
    }
 protected  List<Anime> getFilteredResult(String constrain){

     System.out.println("your string is :_-------------------------------------------------"+constrain);

        List<Anime> rslt= new ArrayList<>();
        for (Anime an: mData){
            if (an.getName().toLowerCase().contains(constrain)){
                rslt.add(an);
            }
        }

     System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+rslt);
        return rslt;
 }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_rating,tv_studio,tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_category= itemView.findViewById(R.id.category);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
