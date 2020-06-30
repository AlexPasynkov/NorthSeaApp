package com.alexlearn.northseasushi;

public class Desert {
    private String desertNameId;
    private int resourceImageId;

    public Desert (String desertNameId, int resourceImageId){
        this.desertNameId = desertNameId;
        this.resourceImageId = resourceImageId;
    }

    public static final Desert[] deserts = {
            new Desert ("Red Velvet", R.drawable.red_velvet),
            new Desert ("Schwarzwald", R.drawable.szwarzwald),
            new Desert ("Snikers", R.drawable.snikers),
            new Desert ("Konkord", R.drawable.konkord),
            new Desert ("Nut Cake", R.drawable.nutt_cake),
            new Desert ("Cheese cake", R.drawable.cheesecake),
            new Desert ("Rolls with banana", R.drawable.sweet_roll_banana),
            new Desert ("Rolls with kiwi", R.drawable.sweet_roll_kowi)
    };

    public String getDesertNameId() {
        return desertNameId;
    }

    public int getDesertResourceImageId() {
        return resourceImageId;
    }
}
