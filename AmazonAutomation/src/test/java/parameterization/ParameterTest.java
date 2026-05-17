package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    void setUp(String br) {

        switch(br.toLowerCase()) 
        {
            case "chrome": driver = new ChromeDriver();
            break;
            case "edge": driver = new EdgeDriver();
            break;
            case "firefox": driver = new FirefoxDriver();
            break;
            default : System.out.println("Invalid Browser");	// This is called as Cross Browser Testing..
            return;
        }

        driver.get("https://iamsandesh23.github.io/selenium.github.io/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    void testImage() {
        boolean imgStatus = driver.findElement(By.xpath("//img[@src='pic.png']")).isDisplayed();
        Assert.assertEquals(imgStatus, true);
    }

    @Test
    void testTitle() {
        Assert.assertEquals(driver.getTitle(), "Kodnest Selenium Demo");
    }

    @Test
    void testURL() {
        Assert	.assertEquals(driver.getCurrentUrl(), "https://iamsandesh23.github.io/selenium.github.io/");
    }

    @AfterClass
    void testClose() {
        driver.close();
    }
}