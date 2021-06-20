package com.company.Demo;


import java.time.Year;

public class Methods {


    public static void main(String[] args) {
        double i = -1.25;
        System.out.println(isPositive(i));

        String name = "Miri";
        int year = 1978;
        System.out.println(age(year));

    }



    public static boolean isPositive(double number) {
        if (number > 0)
            return true;
        else
            return false;
    }

    public static int age(int year ) {
        return Year.now().getValue() - year;

    }
}


