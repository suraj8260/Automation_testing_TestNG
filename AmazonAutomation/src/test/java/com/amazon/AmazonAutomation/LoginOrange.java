package com.amazon.AmazonAutomation;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginOrange {

    WebDriver driver;

    @BeforeClass
    void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    
    @Test(priority = 0)
    void logo() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
    	
    	boolean status = logo.isDisplayed();
    	System.out.println("Logo Status is: "+ status);
    }

    @Test(priority = 1)
    void username() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));

        user.sendKeys("Admin");
    }

    @Test(priority = 2)
    void password() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));

        pass.sendKeys("admin123");
    }

    @Test(priority = 3)
    void login() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));

        loginBtn.click();
    }
    
    @Test(priority = 4)
    void logout() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    	@NonNull
		WebElement stlogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']")));
    	stlogout.click();
    	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	@NonNull
		WebElement logout = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
    	logout.click();
    	
    }
    
    @Test(priority = 5)
    void close() {
    	driver.quit();
    }
    
}