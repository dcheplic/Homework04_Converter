package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class TimeUnit extends Unit {
    private String dimension = dimensionList[1];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to seconds
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("Gs", 1000000000.0);
        convMap.put("Ms", 1000000.0);
        convMap.put("ks", 1000.0);
        convMap.put("hs", 100.0);
        convMap.put("das", 10.0);
        convMap.put("s", 1.0);
        convMap.put("ds", 0.1);
        convMap.put("cs", 0.01);
        convMap.put("ms", 0.001);
        convMap.put("µs", 0.000001);
        convMap.put("ns", 0.000000001);
        convMap.put("ps", 0.000000000001);
        convMap.put("min", 60.0);
        convMap.put("hr", 3600.0);
        convMap.put("day", 86400.0);
        convMap.put("wk", 604800.0);
        convMap.put("fortnight", 1210000.0);
    }

    public TimeUnit(String name) {
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
