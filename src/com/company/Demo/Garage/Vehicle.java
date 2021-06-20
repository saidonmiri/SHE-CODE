package com.company.Demo.Garage;

import java.util.Comparator;
import java.util.Scanner;

public class Vehicle  implements Comparable<Vehicle> {

    private String type;
    private Integer price;
    private String licensePlate;
    private String problemDescription ;
    private Integer year;
    private VehicleStatus status;

    public Vehicle() {System.out.println("Empty Constructor Vehicle");
    }

    @Override
    public int compareTo(Vehicle v) {
        return Comparators.ManufacturingYear.compare(this, v);
    }
    //sub class
    public static class Comparators {

        public static Comparator<Vehicle> ManufacturingYear = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.getYear().compareTo(v2.getYear());
            }
        };

    }

    public Vehicle(String type, Integer price, String licensePlate, String problemDescription, Integer year, VehicleStatus status) {
        this.type = type;
        this.price = price;
        this.licensePlate = licensePlate;
        this.problemDescription = problemDescription;
        this.year = year;
        this.status = status;
    }



    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public Integer getYear() {
        return year;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public boolean getVehicleDetails()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("2.	License Plate Number");
        if (console.hasNext())
        {
            this.setLicensePlate(console.next());
        }
        else
        {
            System.out.println("Invalid license plate. Aborting...");
            return false;
        }

        System.out.println("3.	Description of the problem.");
        if (console.hasNext())
        {
            this.setProblemDescription(console.next());
        }
        else
        {
            System.out.println("Invalid Description. Aborting...");
            return false;
        }

        System.out.println("4.  Year of manufacturing");
        if (console.hasNext())
        {
            this.setYear(console.nextInt());
        }
        else
        {
            System.out.println("Invalid Year. Aborting...");
            return false;
        }
        return true;
    }

    public void printVehicleDetails() {
        System.out.println();
        System.out.println("Vehicle type : " + this.getClass().getSimpleName());
        System.out.println("License plate : " + this.getLicensePlate());
        System.out.println("Manufacturing Year : " + this.getYear());
        System.out.println("Problem Description : " + this.getProblemDescription());
        System.out.println("Status : " + this.getStatus());

    }

   
}
