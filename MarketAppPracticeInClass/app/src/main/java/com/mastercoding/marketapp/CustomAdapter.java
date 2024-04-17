package com.mastercoding.marketapp;

import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mastercoding.marketapp.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<Item> itemList;
    ItemClickListener clickListener;

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public CustomAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding inflatedview = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_layout,
                parent,
                false
        );
        return new MyViewHolder(inflatedview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemLayoutBinding.imageview.setImageResource(item.getItemImg());
        holder.itemLayoutBinding.titleTxt.setText(item.getItemName());
        holder.itemLayoutBinding.descriptionText.setText(item.getItemDesc());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ItemLayoutBinding itemLayoutBinding;

        public MyViewHolder(ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }

        @Override
        public void onClick(View view) {
            Item item = itemList.get(getAdapterPosition());
            Toast.makeText(view.getContext(), "Action  " + item.itemName, Toast.LENGTH_SHORT).show();

        }
    }
}
