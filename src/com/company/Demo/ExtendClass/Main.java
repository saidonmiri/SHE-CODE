package com.company.Demo.ExtendClass;
/*
when we are creating instance of subclass - the constructor of the superclass will be called
if we didnt declare constructor  default superclass constructor will be called
we are declaring a constructor on subclass and adding super with the parameter we want to initiate in super class and NOT in Subclass
the constructor in superclass need to initiate all the parameter in the super , the other paramer that relevant to each subclass will be initiate in subclass
 */
public class Main {

    public static void main(String[] args) {

        Judo yarden = new Judo(50);
        yarden.setName("yarden");
        String[] yadenAchivments ={"A","B","C"};
        yarden.setAchievements(yadenAchivments);
        System.out.println(yarden.toString());


        ////calling to Super
        Judo yarden1 = new Judo("Yarden 2", yadenAchivments,60);
        System.out.println(yarden1.toString());

        Swim inbal = new Swim("hot");
        inbal.setName("inbal");
        //inbal.name = "Inbal";  use getter and setter instead ' just remmber to declare as private
        String[] inbalAchivments ={"D","E","F"};
        inbal.setAchievements(inbalAchivments);
        System.out.println(inbal.toString());

        GymnasticGroup myGymnasticGroup = new GymnasticGroup("123");
        myGymnasticGroup.setName("myGymnasticGroup");
        String[] myGymnasticGroupAchivments ={"DS","ES","FS"};
        myGymnasticGroup.setAchievements(myGymnasticGroupAchivments);
        System.out.println(myGymnasticGroup.toString());


        System.out.println("Call to partially constructor ");
        GymnasticGroup myGymnasticGroup2 = new GymnasticGroup("myGymnasticGroup2" , "Bla Bla");
        System.out.println(myGymnasticGroup2.toString());
    }
}
