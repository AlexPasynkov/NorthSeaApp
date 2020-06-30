package com.alexlearn.northseasushi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter pagerAdapter;;
    private ViewPager2 viewPager;
    private ArrayList <Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);
        fragments.add(new RollFragment());
        fragments.add(new SushiFragment());
        fragments.add(new SoupFragment());

        pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setOrientation(viewPager.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(new MarginPageTransformer(1500));

        TabLayout tabLayout = findViewById(R.id.tabs);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText(R.string.roll_label);
                        break;
                    case 1:
                        tab.setText(R.string.sushi_label);
                        break;
                    case 2:
                        tab.setText(R.string.soup_label);
                        break;
                    case 3:
                        tab.setText(R.string.deserts_label);
                        break;
                    case 4:
                        tab.setText(R.string.drinks_label);
                        break;
                    case 5:
                        tab.setText(R.string.restaurants_label);
                }
            }
        });
        tabLayoutMediator.attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart_image:
                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}