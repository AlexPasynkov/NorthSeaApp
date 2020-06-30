package com.alexlearn.northseasushi;

public class Drink {

    private String drinkNameId;
    private int resourceImageId;

    public Drink (String drinkNameId, int resourceImageId){
        this.drinkNameId = drinkNameId;
        this.resourceImageId = resourceImageId;
    }

    public static final Drink [] drinks = {
            new Drink ("Apple Fresh juice", R.drawable.apple_fresh_juice),
            new Drink ("Carrot Apple Fresh juice", R.drawable.carrot_apple_fresh_juice),
            new Drink ("Carrot Fresh juice", R.drawable.carrot_fresh_juice),
            new Drink ("Oranges Fresh Juice", R.drawable.fresh_orange_juice),
            new Drink ("Ginger lemonade", R.drawable.ginger_lemonade),
            new Drink ("Grapefruit fresh", R.drawable.grape_fruit_fresh),
            new Drink ("Mint lemonade", R.drawable.lemonade_mint),
    };

    public String getDrinkNameId() {
        return drinkNameId;
    }

    public int getDrinkResourceImageId() {
        return resourceImageId;
    }

}
