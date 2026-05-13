package com.amazon.AmazonAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class FacebookDemo {
    WebDriver driver; // Global variable

    @BeforeClass
    void setup() {
        driver = new ChromeDriver(); // local variable initialization
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    void verifyImg() {
        WebElement facebookimg = driver.findElement(By.xpath("//img[@class='xr4gsrn xa83c8o x3oym20 x1i84rja x1is6hmk x1pwz1hh x12fhftt x19kjcj4 x1u2x60b xsjzec5']"));
        boolean statusofImg = facebookimg.isDisplayed();
        System.out.println("logo displayed..." + statusofImg);
    }

    @Test(priority = 2)
    void loginApp() {
        driver.findElement(By.name("email")).sendKeys("Admin");
        driver.findElement(By.name("pass")).sendKeys("Admin123");
        WebElement loginbutton = driver.findElement(By.xpath("//div[@class='x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np x972fbf x10w94by x1qhh985 x14e42zd x9f619 xtvsq51 xqbgfmv xbe3n85 x7a1id4 x1d9i5bo x1xila8y x1bumbmr xc8cyl1']//div[@class='html-div xdj266r xat24cr xexx8yu xyri2b x18d9i69 x1c1uobl x6s0dn4 x78zum5 xl56j7k x1e0frkt xf0ucvx xx2axb6']"));
        loginbutton.click();
    }
    @Test(priority = 3)
    void close() {
    	driver.quit();
    }
}