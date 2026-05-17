package listenerExplanation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenerExplanation.MyListenerClass.class)
public class TestListerner {

    WebDriver driver;
    
    @BeforeClass
    void setUp() {
        
    	driver = new ChromeDriver();
        driver.get("https://iamsandesh23.github.io/selenium.github.io/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
    }

    @Test(priority = 1)
    void testImage() {
        boolean imgStatus = driver.findElement(By.xpath("//img[@src='pic.png']")).isDisplayed();
        Assert.assertEquals(imgStatus, true);
    }

    @Test(priority = 2)
    void testURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://iamsandesh23.github.io/selenium.github.io/");
    }

    @Test(priority = 3, dependsOnMethods = {"testURL"})
    void testTitle() {
        Assert.assertEquals(driver.getTitle(), "Kodnest Selenium Demo");
    }

    @AfterClass
    void testClose() {
        driver.close();
    }
} 