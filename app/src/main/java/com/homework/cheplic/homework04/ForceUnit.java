package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class ForceUnit extends Unit {
    private String dimension = dimensionList[5];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to Newtons
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("GN", 1000000000.0);
        convMap.put("MN", 1000000.0);
        convMap.put("kN", 1000.0);
        convMap.put("hN", 100.0);
        convMap.put("daN", 10.0);
        convMap.put("N", 1.0);
        convMap.put("dN", 0.1);
        convMap.put("cN", 0.01);
        convMap.put("mN", 0.001);
        convMap.put("µN", 0.000001);
        convMap.put("nN", 0.000000001);
        convMap.put("pN", 0.000000000001);
        convMap.put("lb", 4.4482216282509);
        convMap.put("oz", 0.27801385176568);
    }

    public ForceUnit(String name) {
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
