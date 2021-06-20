package com.company.Demo.Garage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car extends  Vehicle {

    public Car() {
    }



    @Override
    public Integer getPrice() {
        return 2000;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + this.getType() + '\'' +
                ", price=" + this.getPrice() +
                ", licensePlateNumber=" + this.getLicensePlate() +
                ", problemDescription='" + this.getProblemDescription() + '\'' +
                ", year=" + getYear() +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
