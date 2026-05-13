package com.amazon.AmazonAutomation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationDemo_ClassLevel {

    @BeforeClass
    void login() {
        System.out.println("This is login");
    }

    @Test(priority = 1)
    void search() {
        System.out.println("This is search");
    }

    @AfterClass
    void logout() {
        System.out.println("This is logout");
    }

    @Test(priority = 2)
    void advanceSearch() {
        System.out.println("This is Advance search");
    }
}