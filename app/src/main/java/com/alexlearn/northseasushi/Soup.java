package com.alexlearn.northseasushi;

public class Soup {

    private String soupNameId;
    private int resourceImageId;

    public Soup (String soupNameId, int resourceImageId){
        this.soupNameId = soupNameId;
        this.resourceImageId = resourceImageId;
    }

    public static final Soup [] soups = {
            new Soup ("Ramen with beef", R.drawable.ramen_with_beef),
            new Soup ("Ramen with pork", R.drawable.ramen_pork),
            new Soup ("Miso beef ramen", R.drawable.miso_beef_ramen),
            new Soup ("Miso pork ramen", R.drawable.miso_pork_ramen),
            new Soup ("Miso soup", R.drawable.miso_soup),
            new Soup ("Miso soup with salmon", R.drawable.miso_soup_salmon),
            new Soup ("Miso soup with eel", R.drawable.miso_soup_eel),
            new Soup ("Miso soup with chicken", R.drawable.miso_soup_chicken)
    };


    public String getSoupNameId() {
        return soupNameId;
    }

    public int getSoupResourceImageId() {
        return resourceImageId;
    }

}
