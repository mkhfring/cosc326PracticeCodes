package com.mastercoding.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapterBack extends RecyclerView.Adapter<CustomAdapterBack.MyViewHolder> {
    List<Item> itemList;
    ItemClickListener clickListener;
    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;

    }

    public CustomAdapterBack(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_layout,
                parent,
                false
        );
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.imageView.setImageResource(item.getItemImg());
        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView title;
        TextView description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title_txt);
            description = itemView.findViewById(R.id.description_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (clickListener != null){
                clickListener.onCLick(view,getAdapterPosition());
            }

        }
    }
}
