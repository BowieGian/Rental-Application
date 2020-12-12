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

// This defines the layout of one Rental in the ListView
// of RentalList
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

        // get a single item from the ListView
        View listViewItem = inflater.inflate(R.layout.layout_rental, null, true);

        // get the UI elements
        ImageView imageViewRental = (ImageView) listViewItem.findViewById(R.id.imageViewRental);
        TextView textPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);
        TextView textRating = (TextView) listViewItem.findViewById(R.id.textViewRating);
        Rental rental = rentalList.get(position);

        // set all the UI elements to the ones in the current rental
        Glide.with(activity).load(rental.getImageUrl()).into(imageViewRental);
        textPrice.setText(Double.toString(rental.getPrice()));
        textRating.setText(Double.toString(rental.getRating()));
        return listViewItem;
    }
}