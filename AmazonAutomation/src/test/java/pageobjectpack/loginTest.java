package pageobjectpack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTest {

	WebDriver driver;
	
	@BeforeClass
	void startUp() {
		
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	void testLogin() {
		
		LoginPageUsingPageFactoryClass lp = new LoginPageUsingPageFactoryClass(driver); 	// Page Object Class By PageFactory
//		LoginPage lp = new LoginPage(driver);												// Page Object class Without PageFactory

		lp.setUserName("fortradingpurposeBN91@gmail.com");
		lp.setPassword("Sandesh6630");
		lp.clickLogin();
		
	}
	@AfterClass
	void close() {
		driver.quit();
	}
}