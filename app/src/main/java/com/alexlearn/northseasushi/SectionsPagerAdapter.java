package com.alexlearn.northseasushi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionsPagerAdapter extends FragmentStateAdapter {

    public SectionsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RollFragment();
            case 1:
                return new SushiFragment();
            case 2:
                return new SoupFragment();
            case 3:
                return new DesertsFragment();
            case 4:
                return new DrinksFragment();
            case 5:
                return new RestaurantsFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

}