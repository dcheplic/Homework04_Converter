package com.homework.cheplic.homework04;

/**
 * Created by Devin on 2/26/2018.
 */

public abstract class Unit {
    protected final String[] dimensionList = {"length", "time", "energy","power",
                                   "mass", "force", "volume", "area"};
//    private String dimension;
//    private String name;
//    private Map<String, Double> convMap;

    public abstract String getDimension();

    public abstract String getName();

    public abstract double getConvFact();
}
