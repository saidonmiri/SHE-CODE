package com.company.Demo;




public class Loop {

    public static void main(String[] args) {


        //Sum of 1-1000
        int sum = 0;
        for (int i=1 ; i<=1000;i++){
            sum+=i;
        }
        System.out.println("The Sum is : " + sum);

        int number=1024;
        while (number > 1 ){
            System.out.println( number);
            number/=2; //also acceptable: number >>= number;
        }

    }

}
