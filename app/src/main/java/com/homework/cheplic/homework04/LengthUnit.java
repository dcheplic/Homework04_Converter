package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class LengthUnit extends Unit {
    private String dimension = dimensionList[0];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to meters
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("Gm", 1000000000.0);
        convMap.put("Mm", 1000000.0);
        convMap.put("km", 1000.0);
        convMap.put("hm", 100.0);
        convMap.put("dam", 10.0);
        convMap.put("m", 1.0);
        convMap.put("dm", 0.1);
        convMap.put("cm", 0.01);
        convMap.put("mm", 0.001);
        convMap.put("µm", 0.000001);
        convMap.put("nm", 0.000000001);
        convMap.put("pm", 0.000000000001);
        convMap.put("in", 0.0254);
        convMap.put("ft", 0.3048);
        convMap.put("yd", 0.9144);
        convMap.put("mi", 1609.34);
        convMap.put("ly", 9461000000000000.0);
    }

    public LengthUnit(String name) {
        this.name = name;
    }

    @Override
    public String getDimension() {
        return dimension;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getConvFact() {
        return convMap.get(name);
    }

    public static boolean contains(String unitName) {
        if(convMap.containsKey(unitName)) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> getKeys() {
        ArrayList<String> keysList = new ArrayList<>();
        for(String key : convMap.keySet())
            keysList.add(key);
        return keysList;
    }
}
