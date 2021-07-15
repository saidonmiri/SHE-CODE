package com.company.Demo.finalProject.main;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Scanner;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Allies extends   User implements java.io.Serializable {

    private boolean canMentor;

    public Allies(){}


    public boolean isCanMentor() {
        return canMentor;
    }

    private void setCanMentor(boolean canMentor) {
        this.canMentor = canMentor;
    }

    @Override
    public  boolean setAdditionalData() {
        Scanner console = new Scanner(System.in);
        System.out.println("Did you mentor before(Y/N):");
        String canMentor = console.next();
        switch (canMentor.toUpperCase()) {
            case "Y":
                this.setCanMentor(true);
                break;
            case "N":
                this.setCanMentor(false);
                System.out.println("Allies must be mentor before");
                return false;
            default:
                System.out.println("Invalid option. Aborting...");
                return false;
        }
        return true;
    }

}
