package com.company.Demo.finalProject.main;


public class UserFactory {

    public static User createUser(int userTypeNumber) {

        switch (userTypeNumber) {
            case 1:
                return new Student();
            case 2:
                return new Mentor();
            case 3:
                return new Allies();
            default:
                return null;
        }
    }
}
