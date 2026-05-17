package parameterization2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InventoryTest {

    private String environmentUrl;

    // Fetching the global suite parameters before the class execution starts
    @BeforeClass
    @Parameters({"browser", "baseUrl"})
    public void setupAutomation(String browserName, String baseUrl) {
        this.environmentUrl = baseUrl;
        System.out.println(">>> Initializing " + browserName + " driver for testing...");
    }

    @Test
    @Parameters({"baseUrl"})
    public void verifyProductFetch(String baseUrl) {
        System.out.println("Executing API GET request to: " + baseUrl + "/products");
        // Your Selenium or RestAssured validation logic goes here
    }
    
    @Test
    public void verifyLocalCache() {
        // This test doesn't take parameters directly, but can use the field set by @BeforeClass
        System.out.println("Checking data cache consistency for: " + this.environmentUrl);
    }
}