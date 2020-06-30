package com.alexlearn.northseasushi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SoupDetailActivity extends AppCompatActivity {

    public static final String EXTRA_SOUP_ID = "soupId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup_detail);

        Toolbar toolbar = findViewById(R.id.soup_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int soupId = (Integer)getIntent().getExtras().get(EXTRA_SOUP_ID);
        String soupName = Soup.soups[soupId].getSoupNameId();
        TextView textView = findViewById(R.id.soup_text);
        textView.setText(soupName);

        int soupImage = Soup.soups[soupId].getSoupResourceImageId();
        ImageView imageView = findViewById(R.id.soup_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, soupImage));

    }
}