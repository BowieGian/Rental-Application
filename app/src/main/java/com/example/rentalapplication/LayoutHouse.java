package com.example.rentalapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LayoutHouse extends ArrayAdapter {
    private Activity activity;
    private List<House> houseList;

    public LayoutHouse(Activity activity, List<House> houseList) {
        super(activity, R.layout.layout_house, houseList);
        this.activity = activity;
        this.houseList = houseList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.layout_house, null, true);

        ImageView imageViewHouse = (ImageView) listViewItem.findViewById(R.id.imageViewHouse);
        TextView textPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);
        TextView textRating = (TextView) listViewItem.findViewById(R.id.textViewRating);
        House house = houseList.get(position);

        Glide.with(activity).load(house.getImageUrl()).into(imageViewHouse);
        textPrice.setText(Double.toString(house.getPrice()));
        textRating.setText(Double.toString(house.getRating()));
        return listViewItem;
    }
}