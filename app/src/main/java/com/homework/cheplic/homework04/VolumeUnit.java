package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class VolumeUnit extends Unit {
    private String dimension = dimensionList[6];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to cubic meters
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("Gm^3", 1000000000.0);
        convMap.put("Mm^3", 1000000.0);
        convMap.put("km^3", 1000.0);
        convMap.put("hm^3", 100.0);
        convMap.put("dam^3", 10.0);
        convMap.put("m^3", 1.0);
        convMap.put("dm^3", 0.1);
        convMap.put("cm^3", 0.01);
        convMap.put("mm^3", 0.001);
        convMap.put("µm^3", 0.000001);
        convMap.put("nm^3", 0.000000001);
        convMap.put("pm^3", 0.000000000001);
        convMap.put("GL", 1000000000.0 * 0.001);
        convMap.put("ML", 1000000.0 * 0.001);
        convMap.put("kL", 1000.0 * 0.001);
        convMap.put("hL", 100.0 * 0.001);
        convMap.put("daL", 10.0 * 0.001);
        convMap.put("L", 0.001);
        convMap.put("dL", 0.1 * 0.001);
        convMap.put("cL", 0.01 * 0.001);
        convMap.put("mL", 0.001 * 0.001);
        convMap.put("µ;", 0.000001 * 0.001);
        convMap.put("nL", 0.000000001 * 0.001);
        convMap.put("pL", 0.000000000001 * 0.001);
        convMap.put("gallon", 0.00378541);
        convMap.put("pint", 0.000473176);
        convMap.put("hoppus", 0.03605);
    }

    public VolumeUnit(String name) {
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
