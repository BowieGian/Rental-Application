package com.example.rentalapplication.ui;

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
import com.example.rentalapplication.R;
import com.example.rentalapplication.data.Rental;

import java.util.List;

public class LayoutRental extends ArrayAdapter {
    private Activity activity;
    private List<Rental> rentalList;

    public LayoutRental(Activity activity, List<Rental> rentalList) {
        super(activity, R.layout.layout_rental, rentalList);
        this.activity = activity;
        this.rentalList = rentalList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.layout_rental, null, true);

        ImageView imageViewRental = (ImageView) listViewItem.findViewById(R.id.imageViewRental);
        TextView textPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);
        TextView textRating = (TextView) listViewItem.findViewById(R.id.textViewRating);
        Rental rental = rentalList.get(position);

        Glide.with(activity).load(rental.getImageUrl()).into(imageViewRental);
        textPrice.setText(Double.toString(rental.getPrice()));
        textRating.setText(Double.toString(rental.getRating()));
        return listViewItem;
    }
}