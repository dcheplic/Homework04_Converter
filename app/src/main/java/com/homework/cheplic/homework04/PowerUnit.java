package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class PowerUnit extends Unit {
    private String dimension = dimensionList[3];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to watts
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("Gw", 1000000000.0);
        convMap.put("Mw", 1000000.0);
        convMap.put("kw", 1000.0);
        convMap.put("hw", 100.0);
        convMap.put("daw", 10.0);
        convMap.put("w", 1.0);
        convMap.put("dw", 0.1);
        convMap.put("cw", 0.01);
        convMap.put("mw", 0.001);
        convMap.put("µw", 0.000001);
        convMap.put("nw", 0.000000001);
        convMap.put("pw", 0.000000000001);
        convMap.put("hp", 745.7);
        convMap.put("Gj/s", 1000000000.0);
        convMap.put("Mj/s", 1000000.0);
        convMap.put("kj/s", 1000.0);
        convMap.put("hj/s", 100.0);
        convMap.put("daj/s", 10.0);
        convMap.put("j/s", 1.0);
        convMap.put("dj/s", 0.1);
        convMap.put("cj/s", 0.01);
        convMap.put("mj/s", 0.001);
        convMap.put("µj/s", 0.000001);
        convMap.put("nj/s", 0.000000001);
        convMap.put("pj/s", 0.000000000001);
    }

    public PowerUnit(String name) {
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
