package com.alexlearn.northseasushi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DesertDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DESERT_ID = "desertId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert_detail);

        Toolbar toolbar = findViewById(R.id.toolbar_desert);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        int desertId = (Integer)getIntent().getExtras().get(EXTRA_DESERT_ID);
        String desertName = Desert.deserts[desertId].getDesertNameId();
        TextView textView = findViewById(R.id.desert_text);
        textView.setText(desertName);
        int desertImage = Desert.deserts[desertId].getDesertResourceImageId();
        ImageView imageView = findViewById(R.id.desert_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, desertImage));
    }
}