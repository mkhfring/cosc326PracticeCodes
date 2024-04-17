package com.mastercoding.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<Item> itemList;

    public ItemClickListener clickListener;


    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }






    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // responsible for creating new view holders for your items

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout,parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Binds the data from your dataset to the views within the view holder
        Item item = itemList.get(position);

        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getItemImg());

    }

    @Override
    public int getItemCount() {
        // Returns the total number of items in your dataset
        return itemList.size();
    }


    public class MyViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener  {
        // Holds references to the views within the item layout

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
        public void onClick(View v) {
            if (clickListener != null){
                clickListener.onCLick(v,getAdapterPosition());
            }
        }
    }
}
