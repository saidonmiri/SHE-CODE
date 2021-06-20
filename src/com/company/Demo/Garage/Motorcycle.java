package com.company.Demo.Garage;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Motorcycle extends  Vehicle {
    private  boolean extraSit;

    public Motorcycle() {
    }

    public Motorcycle(String type, Integer price, String licensePlateNumber, String problemDescription, Integer year, VehicleStatus status, boolean extraSit) {
        super(type, price, licensePlateNumber, problemDescription, year, status);
        this.extraSit = extraSit;
    }



    public boolean isExtraSit() {
        return extraSit;
    }



    @Override
    public Integer getPrice() {
        return 1000;
    }
}
