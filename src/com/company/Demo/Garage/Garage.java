package com.company.Demo.Garage;

public class Garage {
    private static Garage ourInstance = null;
    private GarageManager garageManager;

    private Garage() {
        garageManager = SerializationService.unserializeGarage();
    }


    /*Singleton - can have only one object (an instance of the class) at a time.
    Make constructor as private.
    Write a static method that has return type object of this singleton class. Here, the concept of Lazy initialization is used to write this static method.*/
    public static Garage getInstance() {

        if (ourInstance == null){
            ourInstance = new Garage();
        }
        return ourInstance;
    }



    public void startGarageManagement() {
        garageManager.startGarageManagement();
    }
}



