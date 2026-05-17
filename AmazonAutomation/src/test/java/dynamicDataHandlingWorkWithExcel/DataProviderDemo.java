package dynamicDataHandlingWorkWithExcel;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    WebDriver driver; // global variable

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        
        // Create a map to store Chrome preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        
        // This specific preference disables the "Password Leak Detection" alert
        prefs.put("profile.password_manager_leak_detection", false);
        
        // This turns off the standard password saving prompts as well
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        
        // Pass the preferences into ChromeOptions
        options.setExperimentalOption("prefs", prefs);

        // Pass the options into your driver
        driver = new ChromeDriver(options); 
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "dp1")
    void testLogin(String email, String password) throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password); // hardcoding

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']")));
        button.click();
              
        boolean status = driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
        if (status == true) {
    		WebElement account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']")));
            account.click();
    		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Logout'])[1]")));
            logout.click();
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }

    @AfterClass
    void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name = "dp1")
    Object[][] loginData() {
        Object data[][] = {
        		{"admin@test.com", "pass123"},
                {"user@test.com", "user456"},
                {"guest@test.com", "guest789"},
	            {"kodnest@gmail.com", "test13"},
	            {"johndoe@kod.com", "1234"},
	            {"123@gmail.com", "test123%&"}
            
        };
        return data;
    }
}