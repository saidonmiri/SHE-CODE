package com.company.Demo;



import java.util.Arrays;



public class Array {

    public static void main(String[] args) {

    int[] numbers = {-3,40,74};
    int[] myArray = new int[3];
    String[] arrayString1  = {"Java0" , "Python0" , "CSS0"};
    myArray[0]= 1;
    myArray[1]= 2;
    myArray[2]= 3;

    System.out.println(myArray[2]);
    System.out.println(myArray.length);

    for (int i=0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
    }


    String[] cars = {"Volvo", "BMW", "Ford"};
    for (String i : cars ) {
        System.out.println(i);
    }

        String[][] arrayString2 = {{"Java0", "Python0", "CSS0"}, {"Java1", "Python1", "CSS1"}, {"Java2", "Python2", "CSS2"}};
        System.out.println(arrayString2[1][2]);

    }
}