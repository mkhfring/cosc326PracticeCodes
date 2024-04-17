package com.mastercoding.marketapp;

import java.util.HashMap;
import java.util.Map;

public class DrawableMap {
    private Map<String, Integer> drawableMap;

    public DrawableMap() {
        drawableMap = new HashMap<>();
        initDrawableMap();
    }

    private void initDrawableMap() {
        drawableMap.put("fruit", R.drawable.fruit);
        drawableMap.put("vegitables", R.drawable.vegitables);
        drawableMap.put("bread", R.drawable.bread);
        drawableMap.put("beverage", R.drawable.beverage);
        drawableMap.put("milk", R.drawable.milk);
        drawableMap.put("popcorn", R.drawable.popcorn);
    }

    public int getDrawableId(String imageName) {
        Integer drawableId = drawableMap.get(imageName);
        if (drawableId == null) {
            throw new IllegalArgumentException("No drawable found for image name: " + imageName);
        }
        return drawableId;
    }
}
