package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class AreaUnit extends Unit {
    private String dimension = dimensionList[7];
    private  String name;
    private static final Map<String, Double> convMap; //Conversion to square feet
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("ft^2", 1.0);
        convMap.put("Gm^2", 1000000000.0 * 10.7639);
        convMap.put("Mm^2", 1000000.0 * 10.7639);
        convMap.put("km^2", 1000.0 * 10.7639);
        convMap.put("hm^2", 100.0 * 10.7639);
        convMap.put("dam^2", 10.0 * 10.7639);
        convMap.put("m^2", 10.7639);
        convMap.put("dm^2", 0.1 * 10.7639);
        convMap.put("cm^2", 0.01 * 10.7639);
        convMap.put("mm^2", 0.001 * 10.7639);
        convMap.put("µm^2", 0.000001 * 10.7639);
        convMap.put("nm^2", 0.000000001 * 10.7639);
        convMap.put("pm^2", 0.000000000001 * 10.7639);
        convMap.put("acre", 43560.0);
        convMap.put("are", 1076.39);
        convMap.put("hectare", 107639.0);
    }

    public AreaUnit(String name) {
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
