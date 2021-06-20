package com.company.Demo.ExtendClass;

import java.util.Arrays;

public class Judo extends Athlete {
    private int weight;



    public Judo() {
        System.out.println("Creating Judo");
    }

    public Judo(int weight) {
        this.weight = weight;
    }

    public Judo(String name, String[] achievements, int weight) {

        super(name, achievements);// will use the constructor of the parent if not exist will call to empty constructor on parent class
        System.out.println("used Super");
        this.weight = weight;

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Judo{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", achievements=" + Arrays.toString(achievements) +
                '}';
    }
}
