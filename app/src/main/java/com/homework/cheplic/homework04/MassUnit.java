package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class MassUnit extends Unit {
    private String dimension = dimensionList[4];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to grams
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("Gg", 1000000000.0);
        convMap.put("Mg", 1000000.0);
        convMap.put("kg", 1000.0);
        convMap.put("hg", 100.0);
        convMap.put("dag", 10.0);
        convMap.put("g", 1.0);
        convMap.put("dg", 0.1);
        convMap.put("cg", 0.01);
        convMap.put("mg", 0.001);
        convMap.put("µg", 0.000001);
        convMap.put("ng", 0.000000001);
        convMap.put("pg", 0.000000000001);
        convMap.put("slug", 14593.9);
    }

    public MassUnit(String name) {
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
        return convMap.containsKey(unitName);
    }

    public static ArrayList<String> getKeys() {
        ArrayList<String> keysList = new ArrayList<>();
        for(String key : convMap.keySet())
            keysList.add(key);
        return keysList;
    }
}
