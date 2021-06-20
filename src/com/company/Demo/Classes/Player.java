package com.company.Demo.Classes;

public class Player {
    String name;
    int point;

    //constructor - without return value with inputs
    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }
    //constructor - without return value and without inputs
    public Player() {
        this.name = "Default";
        this.point = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }

    public static void main(String[] args) {


        Player myPlayer = new Player("Miri",0);
//        myPlayer.name = "Miri";
//        myPlayer.point = 0 ;
        System.out.println(myPlayer.toString());

        myPlayer.setPoints(3);
        System.out.println(myPlayer.toString());
        myPlayer.setPoints(5);

//        System.out.println(myPlayer.getName());
//        System.out.println(myPlayer.getPoints());
        System.out.println(myPlayer.toString());

        Player myPlayer2 = new Player("Ori",5);
        System.out.println(myPlayer2.toString());

        Player myPlayer3 = new Player();
        System.out.println(myPlayer3.toString());
    }

    String getName()
    {
        return name;
    }

    int getPoints()
    {
        return point;
    }

    void setPoints(int newPoints)
    {
        point += newPoints ;
    }
}
