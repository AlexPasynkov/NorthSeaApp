package com.alexlearn.northseasushi;

public class Restaurants {
    private String restaurantNameId;
    private int resourceImageId;

    public Restaurants (String restaurantNameId, int resourceImageId){
        this.restaurantNameId = restaurantNameId;
        this.resourceImageId = resourceImageId;
    }

    public static final Restaurants [] cities = {
            new Restaurants ("Gdansk", R.drawable.gdansk),
            new Restaurants ("Gdynia", R.drawable.gdynia),
            new Restaurants ("Katowice", R.drawable.katowice),
            new Restaurants ("Krakow", R.drawable.krakow),
            new Restaurants ("Poznan", R.drawable.poznan),
            new Restaurants ("Sopot", R.drawable.sopot),
            new Restaurants ("Warsaw", R.drawable.warszawa),
            new Restaurants ("Wroclaw", R.drawable.wroclaw)
    };

    public String getRestaurantNameId() {
        return restaurantNameId;
    }

    public int getRestaurantResourceImageId() {
        return resourceImageId;
    }
}
