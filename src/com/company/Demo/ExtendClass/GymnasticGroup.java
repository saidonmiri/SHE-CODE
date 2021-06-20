package com.company.Demo.ExtendClass;

import java.util.Arrays;

public class GymnasticGroup extends Athlete {
    String item;

    public GymnasticGroup() {
        System.out.println("Creating GymnasticGroup");
    }

    public GymnasticGroup(String item) {
        this.item = item;
    }

    public GymnasticGroup(String name, String[] achievements) {
        super(name, achievements);
    }

    public GymnasticGroup(String name, String[] achievements, String item) {
        super(name, achievements);
        this.item = item;
    }

    public GymnasticGroup(String name,  String item) {

        this(name,new String[]{} , item);/// it will call to the constructor that exist in the same class - SUB class
        System.out.println("use partially constructor ");
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }



    @Override
    public String toString() {
        ////instead of writing the parameters of the super we use super.tostring()
        String output = super.toString() + "item='" + item ;
        return output;

//        return "GymnasticGroup{" +
//                "item='" + item + '\'' +
//                ", name='" + name + '\'' +
//                ", achievements=" + Arrays.toString(achievements) +
//                '}';
    }
}
