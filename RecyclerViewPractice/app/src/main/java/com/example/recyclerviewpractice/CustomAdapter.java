package com.example.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<Item> itemList;
    Context context;

    public CustomAdapter(List<Item> itemList, Context context) {

        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_layout,
                parent,
                false
        );

        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.image.setImageResource(item.getImagesource());
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView name;
        TextView description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.title_txt);
            description = itemView.findViewById(R.id.description_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Item item = itemList.get(getAdapterPosition());
            Toast.makeText(
                    context,
                    "The item is " + item.getName(),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
