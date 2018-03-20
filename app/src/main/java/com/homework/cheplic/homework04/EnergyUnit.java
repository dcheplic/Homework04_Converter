package com.homework.cheplic.homework04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Devin on 3/2/2018.
 */

public class EnergyUnit extends Unit {
    private String dimension = dimensionList[2];
    private String name;
    private static final Map<String, Double> convMap; //Conversion to joules
    static{
        convMap = new LinkedHashMap<>();
        convMap.put("Gj", 1000000000.0);
        convMap.put("Mj", 1000000.0);
        convMap.put("kj", 1000.0);
        convMap.put("hj", 100.0);
        convMap.put("daj", 10.0);
        convMap.put("j", 1.0);
        convMap.put("dj", 0.1);
        convMap.put("cj", 0.01);
        convMap.put("mj", 0.001);
        convMap.put("µj", 0.000001);
        convMap.put("nj", 0.000000001);
        convMap.put("pj", 0.000000000001);
        convMap.put("GeV", 1000000000.0 * 0.000000000000000000160218);
        convMap.put("MeV", 1000000.0 * 0.000000000000000000160218);
        convMap.put("keV", 1000.0 * 0.000000000000000000160218);
        convMap.put("heV", 100.0 * 0.000000000000000000160218);
        convMap.put("daeV", 10.0 * 0.000000000000000000160218);
        convMap.put("eV", 0.000000000000000000160218);
        convMap.put("deV", 0.1 * 0.000000000000000000160218);
        convMap.put("ceV", 0.01 * 0.000000000000000000160218);
        convMap.put("meV", 0.001 * 0.000000000000000000160218);
        convMap.put("µeV", 0.000001 * 0.000000000000000000160218);
        convMap.put("neV", 0.000000001 * 0.000000000000000000160218);
        convMap.put("peV", 0.000000000001 * 0.000000000000000000160218);
        convMap.put("btu", 1055.06);
        convMap.put("boe", 6118000000.0);
    }

    public EnergyUnit(String name) {
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
