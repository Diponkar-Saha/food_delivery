package com.example.food_delivery.ui.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_delivery.R;
import com.example.food_delivery.model.DataController;
import com.example.food_delivery.model.MenuItem;
import com.example.food_delivery.model.Restrurent;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.viewHolder> {
    List<MenuItem> allmenuItems;
    public MenuAdapter(List<MenuItem> allRestaurnats ) {
        this.allmenuItems = allRestaurnats;

    }

    @NonNull
    @Override
    public MenuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);

        return new MenuAdapter.viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.viewHolder holder, int position) {
        MenuItem current=allmenuItems.get(position);

    }

    @Override
    public int getItemCount() {
        if (allmenuItems==null||allmenuItems.size()==0){
            return 0;
        }else{
            return allmenuItems.size();
        }

    }



    public  class viewHolder extends RecyclerView.ViewHolder{

        TextView menuItemName, menuDescription,priceTextview;

        public viewHolder(@NonNull View itemView) {
            super(itemView);


            menuItemName =itemView.findViewById(R.id.itemNameTextView);
            menuDescription =itemView.findViewById(R.id.itemDescriptionTextView);
            priceTextview=itemView.findViewById(R.id.itemPrceTextView);

        }
    }
}
