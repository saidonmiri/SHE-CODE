package com.company.Demo.Garage;



public class MainClass {

    private GarageManager garageManager;

    public void startGarageManagement() {
        garageManager.startGarageManagement();
    }


    public static void main(String[] args) {

        Garage garage = Garage.getInstance();
        garage.startGarageManagement();
    }
}



