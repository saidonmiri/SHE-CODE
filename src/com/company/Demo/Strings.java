package com.company.Demo;


import java.util.Random;
import java.util.Scanner;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeString.substr;

public class Strings {

    public static void main(String[] args) {

        Random rnd = new Random();
        System.out.println("Random number : " + rnd.nextInt(100));


        System.out.println("Random number : " + getRandomNumberUsingNextInt(150, 400));


        Scanner console = new Scanner(System.in);
        System.out.println("Enter First String");
        String firstString = console.next();
        System.out.println("Enter Second String");
        String secondString = console.next();
        //System.out.println("Largest String is : " + largestString(firstString,secondString) );
        System.out.println("Insert 1 into 2  : " + equalStringInsert(firstString,secondString) );//random number in specific range


    }

    public static String largestString(String first , String second)
    {
         if (first.length() > second.length())
             return  first;
         else
            return second;

    }

    public static String equalStringInsert(String first , String second)
    {
       int len = first.length();
       String newString = "";
       int middle = 0 ;
       if (len%2==0)
       {
           middle = len/2 +1;
       }
           else
       {
           middle = (len/2);
       }

           return substr(first,0,middle) + second + substr(first,middle ,len);


    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
