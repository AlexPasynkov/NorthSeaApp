package com.alexlearn.northseasushi;

public class Sushi {

    private String sushiNameId;
    private int resourceImageId;

    public Sushi (String sushiNameId, int resourceImageId){
        this.sushiNameId = sushiNameId;
        this.resourceImageId = resourceImageId;
    }

    public static final Sushi [] sushis = {
            new Sushi ("Sushi seaweed", R.drawable.sushi_sivid),
            new Sushi("Masago sushi", R.drawable.sushi_masago_kaviar),
            new Sushi ("Shake sushi", R.drawable.sushi_shake_norm),
            new Sushi("Smoke salmon sushi", R.drawable.smoke_shake),
            new Sushi("Spicy Shake sushi", R.drawable.shake_spicy),
            new Sushi("Unagi sushi", R.drawable.sushi_unagi),
            new Sushi("Unagi Spicy", R.drawable.unagi_spicy),
            new Sushi("Fila Kunsej Sushi", R.drawable.fila_kunsej)
    };

    public String getSushiNameId() {
        return sushiNameId;
    }

    public int getSushiResourceImageId() {
        return resourceImageId;
    }
}
