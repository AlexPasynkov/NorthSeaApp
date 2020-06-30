package com.alexlearn.northseasushi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantDetailFragment extends AppCompatActivity {
    public static final String EXTRA_RESTAURANT_ID = "restaurantId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail_fragment);

        Toolbar toolbar = findViewById(R.id.toolbar_restaurant);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int restaurantId = (Integer)getIntent().getExtras().get(EXTRA_RESTAURANT_ID);
        String restaurantName = Restaurants.cities[restaurantId].getRestaurantNameId();
        TextView textView = findViewById(R.id.restaurant_text);
        textView.setText(restaurantName);
        int resourceImageIdImage = Restaurants.cities[restaurantId].getRestaurantResourceImageId();
        ImageView imageView = findViewById(R.id.restaurant_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceImageIdImage));
    }
}