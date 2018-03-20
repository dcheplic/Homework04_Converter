package com.homework.cheplic.homework04;

import java.util.List;

/**
 * Created by Devin on 2/26/2018.
 */

public class Conversion {

    /*LENGTH STD = METER
    * TIME STD = SECOND
    * ENERGY STD = JOULE
    * POWER STD = WATT
    * MASS STD = GRAM
    * FORCE STD = NEWTON
    * VOLUME STD = CUBIC METER
    * AREA STD = SQUARE FOOT */

    private static Unit startUnit;
    private static Unit endUnit;

    public static Conversion from(String startName) {
        startUnit = setUnit(startName);
        return new Conversion();
    }

    public static Conversion to(String endName) {
        endUnit = setUnit(endName);
        return new Conversion();
    }

    public static double convert(double value) {
        return (value * startUnit.getConvFact()) / endUnit.getConvFact();
    }

    private static Unit setUnit(String name){
        Unit u = null;
        if(LengthUnit.contains(name))
            u = new LengthUnit(name);
        if(TimeUnit.contains(name))
            u = new TimeUnit(name);
        if(EnergyUnit.contains(name))
            u = new EnergyUnit(name);
        if(PowerUnit.contains(name))
            u = new PowerUnit(name);
        if(MassUnit.contains(name))
            u = new MassUnit(name);
        if(ForceUnit.contains(name))
            u = new ForceUnit(name);
        if(VolumeUnit.contains(name))
            u = new VolumeUnit(name);
        if(AreaUnit.contains(name))
            u = new AreaUnit(name);
        return u;
    }

    // For testing purposes only
    public static Unit getStartUnit() {
        return startUnit;
    }

    public static Unit getEndUnit() {
        return endUnit;
    }
}
