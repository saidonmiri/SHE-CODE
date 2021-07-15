//package com.company.Demo.finalProject.test;
//
//import com.company.Demo.finalProject.main.SheCodesManager;
//import com.company.Demo.finalProject.main.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
//
//import java.util.HashMap;
//
//
//public class SheCodesManagerTest {
//    private final String  adminUser =  "miri.saidon.she-codes";
//    private final String  adminPassword = "123456";
//    SheCodesManager users = new SheCodesManager();
//
//    @BeforeAll
//    public void beforeAll()
//    {
//
//        users = new HashMap<String, User>();
//    }
//
//    @Test
//    public void validatePermission()
//    {
//
//        Assert.assertTrue( users.validatePermission(adminUser ,adminPassword , true ));
//    }
//}