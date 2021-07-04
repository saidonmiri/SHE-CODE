package com.company.Demo.finalProject;



public class MainClass {

    private SheCodesManager sheCodesManager;

    public void startSheCodesManagement() {
        sheCodesManager.startSheCodesManagement();
    }


    public static void main(String[] args) {

        SheCodes sheCodes = SheCodes.getInstance();
        sheCodes.startSheCodesManagement();
    }

}
