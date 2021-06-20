package com.company.Demo.FinalProject;


public class SheCodes {
    private static SheCodes ourInstance = null;
    private SheCodesManager sheCodesManager;

    private SheCodes() {

        sheCodesManager = SerializationService.unserializeUser();
    }


    /*Singleton - can have only one object (an instance of the class) at a time.
    Make constructor as private.
    Write a static method that has return type object of this singleton class. Here, the concept of Lazy initialization is used to write this static method.*/
    public static SheCodes getInstance() {

        if (ourInstance == null){
            ourInstance = new SheCodes();
        }
        return ourInstance;
    }



    public void startSheCodesManagement() {
        sheCodesManager.startSheCodesManagement();
    }
}



