package com.company.Demo.Garage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Truck extends Vehicle {
    private   Integer weightLimit;

    public Truck() {

    }

    public Truck(String type, Integer price, String licensePlateNumber, String problemDescription, Integer year, VehicleStatus status, Integer weightLimit) {
        super(type, price, licensePlateNumber, problemDescription, year, status);
        this.weightLimit = weightLimit;
    }


    public Integer getWeightLimit() {
        return weightLimit;
    }

    @Override
    public Integer getPrice() {
         return 5000;
    }


}
