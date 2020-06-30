package com.alexlearn.northseasushi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK_ID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_drink);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int drinkID = (Integer)getIntent().getExtras().get(EXTRA_DRINK_ID);
        String drinkName = Drink.drinks[drinkID].getDrinkNameId();
        TextView textView = findViewById(R.id.drink_text);
        textView.setText(drinkName);
        int drinkImage =  Drink.drinks[drinkID].getDrinkResourceImageId();
        ImageView imageView = findViewById(R.id.drink_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, drinkImage));
    }
}