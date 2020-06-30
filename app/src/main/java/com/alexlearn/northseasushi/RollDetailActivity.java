package com.alexlearn.northseasushi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RollDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ROLL_ID = "rollId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int rollId = (Integer)getIntent().getExtras().get(EXTRA_ROLL_ID);
        String rollName = Rolls.japanRolls[rollId].getRollNameId();
        TextView textView = findViewById(R.id.roll_text);
        textView.setText(rollName);
        int rollImage = Rolls.japanRolls[rollId].getResourceImageId();
        ImageView imageView = findViewById(R.id.roll_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, rollImage));

    }
}