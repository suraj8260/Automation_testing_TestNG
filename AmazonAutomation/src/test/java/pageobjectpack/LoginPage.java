package pageobjectpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    LoginPage(WebDriver driver) 
    {
        this.driver = driver;
    }

    // locators

    By user_name_loc = By.xpath("//input[@id='input-email']");
    By user_password_loc = By.xpath("//input[@id='input-password']");
    By click_button_loc = By.xpath("//input[@value='Login']");


    // actions method 

    public void setUserName(String user) {
        driver.findElement(user_name_loc).sendKeys(user);
    }

    public void setPassword(String password) {
        driver.findElement(user_password_loc).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(click_button_loc).click();
    }
}