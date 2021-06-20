package com.company.Demo;


import java.util.Scanner;

public class ScannerIF {

    public static void main(String[] args)    {


        //http://programmingbydoing.com/a/how-old-are-you.html

        Scanner console = new Scanner(System.in);
        System.out.println("Hey whats's your name?");
        String name = console.next();
        System.out.println("Ok, "+ name + "," +" how old are you?");
        int age = console.nextInt();
        if (age > 25)
        {
            System.out.println("You can do anything that's legal,  " + name + ".");
        }
        else {
            System.out.println("You can't rent a car,  " + name + ".");
            if (age < 18) {
                System.out.println("You can't vote,  " + name + ".");
            }
            if (age < 16) {
                System.out.println("You can't drive, " + name + ".");
            }
        }

            console.close();


        }

}
