package com.company.Demo.FinalProject;


import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Scanner;

@XmlTransient
@XmlSeeAlso({Mentor.class,Student.class})
public class User implements java.io.Serializable {


    private String firstName;
    private String lastName;
    private String type;
    private String alumniId ;
    private String password ;
    private String linkedInPage ;
    private static final String SUFFIX = "she-codes";

    public User(){}

    public User(String firstName, String lastName, String type, String alumniId, String password, String linkedInPage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.alumniId = alumniId;
        this.password = password;
        this.linkedInPage = linkedInPage;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }

    public String getAlumniId() {
        return alumniId;
    }

    public String getPassword() {
        return password;
    }

    public String getLinkedInPage() {
        return linkedInPage;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAlumniId() {
        this.alumniId = this.getFirstName() + "." + this.getLastName() + "." + SUFFIX ;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLinkedInPage(String linkedInPage) {
        this.linkedInPage = linkedInPage;
    }

    public void printUserDetails(){

        System.out.println();
        System.out.println("First Name : " + this.getFirstName());
        System.out.println("Last Name : " + this.getLastName());
        System.out.println("Password : " + this.getPassword());
        System.out.println("Type : " + this.getType());
        System.out.println("linked In Page : " + this.getLinkedInPage());
        System.out.println("Alumni Id : " + this.getAlumniId());


    }

    public  void setAdditionalData(){}

    public boolean setUserDetails()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("First Name");
        if (console.hasNext())
        {
            this.setFirstName(console.next());
        }
        else
        {
            System.out.println("Invalid first name. Aborting...");
            return false;
        }

        System.out.println("Last Name");
        if (console.hasNext())
        {
            this.setLastName(console.next());
        }
        else
        {
            System.out.println("Invalid Last Name. Aborting...");
            return false;
        }
        this.setAlumniId();

        System.out.println("Suggested Password");
        if (console.hasNext())
        {
            this.setPassword(console.next());
        }
        else
        {
            System.out.println("Invalid Password. Aborting...");
            return false;
        }

        System.out.println("linkedIn Page - Optional");
        if (console.hasNext())
        {
            this.setLinkedInPage(console.next());
        }
        else
        {
            this.setLinkedInPage("");
        }



        return true;
    }
}
