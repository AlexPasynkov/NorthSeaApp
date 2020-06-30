package com.alexlearn.northseasushi;

public class Rolls {

    private String rollName;
    private int resourceImageId;

    public Rolls (String rollName, int resourceImageId){
        this.rollName = rollName;
        this.resourceImageId = resourceImageId;
    }

    public static final Rolls[] japanRolls = {
            new Rolls ("Philadelphia Unagi", R.drawable.philadelhia_unagi),
            new Rolls("Philadelphia Salmon", R.drawable.philadelphia_cheese_cucumber),
            new Rolls("Golden Dragon", R.drawable.golden_dragon),
            new Rolls("California Masago", R.drawable.california_masago),
            new Rolls("Green Dragon", R.drawable.green_dragon),
            new Rolls("Black Dragon", R.drawable.black_dragon),
            new Rolls("Fire Dragon", R.drawable.fire_dragon),
            new Rolls("Roll with hot vegetable", R.drawable.roll_with_hot_vegetables)
    };

    public String getRollNameId() {
        return rollName;
    }

    public int getResourceImageId() {
        return resourceImageId;
    }
}
