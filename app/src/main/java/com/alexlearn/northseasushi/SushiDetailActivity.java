package com.alexlearn.northseasushi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SushiDetailActivity extends AppCompatActivity {

    public static final String EXTRA_SUSHI_ID = "sushiID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushi_detail);

        Toolbar toolbar = findViewById(R.id.toolbarSushi);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int sushiId = (Integer)getIntent().getExtras().get(EXTRA_SUSHI_ID);
        String sushiName = Sushi.sushis[sushiId].getSushiNameId();
        TextView textView = findViewById(R.id.sushi_text);
        textView.setText(sushiName);

        int sushiImage = Sushi.sushis[sushiId].getSushiResourceImageId();
        ImageView imageView = findViewById(R.id.sushi_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, sushiImage));

    }
}