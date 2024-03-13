package com.example.inclasscityadapterpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CityModel> {
    Context context;
    ArrayList<CityModel> cities;

    public CustomAdapter(Context context, ArrayList<CityModel> cities) {
        super(context, R.layout.cite_item_template, cities);
        this.context = context;
        this.cities = cities;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CityModel city = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.cite_item_template,
                    parent,
                    false
            );
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageview);
            viewHolder.cityName = convertView.findViewById(R.id.cityName);
            viewHolder.population = convertView.findViewById(R.id.population);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(city.getImageSource());
        viewHolder.cityName.setText(city.getCityName());
        viewHolder.population.setText(city.getPopulation());
        return convertView;


    }
    private static class ViewHolder{
        ImageView imageView;
        TextView cityName;
        TextView population;
    }
}
