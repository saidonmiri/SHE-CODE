package com.company.Demo.Garage;

public class VehicleFactory {

    public static Vehicle createVehicle(int vehicleTypeNumber) {

        switch (vehicleTypeNumber) {
            case 1:
                return new Car();
            case 2:
                return new Truck();
            case 3:
                return new Motorcycle();
            default:
                return null;
        }
    }
}
