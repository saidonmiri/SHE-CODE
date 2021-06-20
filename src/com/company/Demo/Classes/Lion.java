package com.company.Demo.Classes;


import java.util.Arrays;

public class Lion {
    int height;
    int weight;
    String color;
    double roarDecibles;
    int maneLength;
    ParentLion parent;
    int[] lionFoodIndex = new int[3];



    public static void main(String[] args) {


        Lion myLion1 = new Lion();
        ParentLion myParentLion = new ParentLion();

        myLion1.height = 90;
        myLion1.weight = 100 ;
        myLion1.color = "Black" ;
        myLion1.roarDecibles=1.2;
        myLion1.maneLength = 1;
        myLion1.parent = myParentLion;
        myLion1.lionFoodIndex[0] = 0;



//        System.out.println(myLion1.height);
//        System.out.println(myLion1.weight);
//        System.out.println(myLion1.color);
//
//        System.out.println(myLion1.roarDecibles);
//        System.out.println(myLion1.maneLength);
//        System.out.println(myLion1.hunt());
//        System.out.println(myLion1.lionFoodIndex[0]);
          System.out.println(myLion1.toString());
          //Lion{height=90, weight=100, color='Black', roarDecibles=1.2, maneLength=1, parent=com.company.Demo.Classes.ParentLion@1b6d3586, lionFoodIndex=[0, 0, 0]}
        //Brown

        Lion myLion2 = new Lion();

        myLion2.height = 95;
        myLion2.weight = 105 ;
        myLion2.color = "Brown" ;
        myLion2.roarDecibles=1.3;
        myLion2.maneLength = 2;

        myLion2.lionColor();
        myLion2.setweight(50);
//        System.out.println(myLion2.weight);
        System.out.println(myLion2.toString());
//        Lion{height=95, weight=50, color='Brown', roarDecibles=1.3, maneLength=2, parent=null, lionFoodIndex=[0, 0, 0]}

        Lion myLion3 = new Lion();
        myLion3 = myLion2;
//        System.out.println(myLion3.color);
        //Lion{height=95, weight=50, color='Brown', roarDecibles=1.3, maneLength=2, parent=null, lionFoodIndex=[0, 0, 0]}
        System.out.println(myLion3.toString());


        //use default constructor
        //Lion{height=0, weight=0, color='null', roarDecibles=0.0, maneLength=0, parent=null, lionFoodIndex=[0, 0, 0]}
        Lion myLion4 = new Lion();
        System.out.println(myLion4.toString());



    }

    void setRoarDecibles(){
        System.out.println("RRRoaRRR");
    }

    String hunt(){
        return "Rabbit";
    }

    void lionColor(){
        System.out.println(color);
    }

    void setweight(int weight)
//    void setweight(int newWeight)
    {
//        weight = newWeight;
        this.weight = weight; // same param name
    }

    @Override
    public String toString() {
        return "Lion{" +
                "height=" + height +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", roarDecibles=" + roarDecibles +
                ", maneLength=" + maneLength +
                ", parent=" + parent +
                ", lionFoodIndex=" + Arrays.toString(lionFoodIndex) +
                '}';
    }
}
