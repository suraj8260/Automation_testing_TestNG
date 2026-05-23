package pageobjectpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingPageFactoryClass {
    
    // constructor
    
    WebDriver driver;
    
    LoginPageUsingPageFactoryClass(WebDriver driver){
        this.driver = driver;
        
        PageFactory.initElements(driver, this);
    }
    
 // locators

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement username;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement pwd;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement clickButton;


    // action methods

    public void setUserName(String user) {
        
        username.sendKeys(user);
        
    }

    public void setPassword(String password) {
        
        pwd.sendKeys(password);
        
    }
    
    public void clickLogin() {
    	clickButton.click();
    }
}
