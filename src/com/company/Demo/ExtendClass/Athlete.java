package com.company.Demo.ExtendClass;

import java.util.Arrays;

public class Athlete {
    protected String name;
    protected String[] achievements;

    public Athlete() {
        System.out.println("Creating Athlete");
    }

    public Athlete(String name, String[] achievements) {
        this.name = name;
        this.achievements = achievements;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAchievements(String[] achievements) {
        this.achievements = achievements;
    }

    public String getName() {
        return name;
    }

    public String[] getAchievements() {
        return achievements;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", achievements=" + Arrays.toString(achievements) +
                '}';
    }
}
