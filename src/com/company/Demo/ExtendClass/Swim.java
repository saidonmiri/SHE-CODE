package com.company.Demo.ExtendClass;

import java.util.Arrays;

public class Swim extends Athlete {
    String  heat;

    public Swim() {
        System.out.println("Creating Swim");
    }
    public Swim(String heat) {
        this.heat = heat;
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    @Override
    public String toString() {
        return "Swim{" +
                "heat='" + heat + '\'' +
                ", name='" + name + '\'' +
                ", achievements=" + Arrays.toString(achievements) +
                '}';
    }


}
