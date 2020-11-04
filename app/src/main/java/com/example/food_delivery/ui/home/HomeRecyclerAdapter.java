package com.example.food_delivery.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_delivery.R;
import com.example.food_delivery.model.DataController;
import com.example.food_delivery.model.Restrurent;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.viewHolder> {
    List<Restrurent> allRestaurants;
   // Context context;

    public HomeRecyclerAdapter(List<Restrurent> allRestaurants) {
        this.allRestaurants = allRestaurants;
       // this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Restrurent curent=allRestaurants.get(position);
        holder.restaurentName.setText(curent.getRestrurentName());
        holder.restaurentDescription.setText(curent.getRestrurentDescription());
        Picasso.get().load(curent.getRestrurentImageUrl()).into(holder.restaurentImage);
    }

    @Override
    public int getItemCount() {
        if(allRestaurants==null||allRestaurants.size()==0){
            return 0;
        }else{
            return allRestaurants.size();
        }

        //return 0;
    }

    public class viewHolder extends  RecyclerView.ViewHolder{
        ImageView restaurentImage;
        TextView restaurentName,restaurentDescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            restaurentImage=itemView.findViewById(R.id.restaurentImage);
            restaurentName=itemView.findViewById(R.id.restaurentNameTextview);
            restaurentDescription=itemView.findViewById(R.id.restaurentDescripNameTextview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Restrurent current=allRestaurants.get(getAdapterPosition());
                    DataController.instance.getResaurantInterface().onRestaurantClick(current);

                }
            });
        }
    }
}
