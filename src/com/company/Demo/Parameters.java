package com.company.Demo;



public class Parameters {

    public static void main(String[] args) {
        System.out.print("Miri");
        System.out.println("Saidon");

        //https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        /* Integer - which stores whole numbers*/
        int passengers; // declare - default value 0
        passengers = 0; //initialize
        passengers = passengers + 5;
        passengers = passengers - 3;
        passengers = passengers - 1 + 5;
        passengers++;
        System.out.println(passengers);

        final int yearBorn = 1968; // can't  be manipulated

        /* String which stores multiple characters using double quotes*/
        String driverFirstName; // declare - default value null - not empty string and string
        driverFirstName = "Hamish";
        String driverLastName = "Blake";
        System.out.println(driverFirstName.length()); //print length of the string length is NOT 0
        System.out.println(driverFirstName.toUpperCase()); //Change to upper case

        System.out.println(driverFirstName + " " + driverLastName); //Concatenation

        System.out.println("The Name : " + driverFirstName + " Contains " + driverFirstName.length() + " Characters"); //Concatenation of string and numbers

        String salutations = new String("Hello World");

        System.out.println("\"Hello World\"");
        // Prints: "Hello World

        System.out.println("This is the backslash symbol: \\");
        // Prints: This is the backslash symbol: \

        System.out.println("Hello\nGoodbye");
        /*
        Prints:
        Hello
        Goodbye
        */


        String person1 = "Paul";
        String person2 = "John";
        String person3 = "Paul";

        System.out.println(person1.equals(person2));
        // Prints false, since "Paul" is not "John"

        System.out.println(person1.equals(person3));
        // Prints true, since "Paul" is "Paul"

        /* Char  which stores single characters using single quotes*/
        char three = '3';

        /* Long  */

        /* Double - which stores bigger whole numbers and decimal numbers */
        //default value 0.0

        /* Boolean   which stores true and false*/
        //default value false
        String str1 = "";
        String str2 = null;
        System.out.println(str1 == str2);


        //The modulo operator %, gives us the remainder after two numbers are divided.

        int cookiesBaked = 10;
        int cookiesLeftover = 10 % 3;
        //cookiesLeftover holds 1


    }

}
