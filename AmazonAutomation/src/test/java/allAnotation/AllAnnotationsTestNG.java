package allAnotation;
import org.testng.annotations.*;

public class AllAnnotationsTestNG {

    // Executes once before all tests in the suite
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    // Executes once after all tests in the suite
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    // Executes before any test tag in testng.xml
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    // Executes after all test tags in testng.xml
    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    // Executes before first test method in current class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    // Executes after all test methods in current class
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    // Executes before each test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    // Executes after each test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    // Executes before groups
    @BeforeGroups("smoke")
    public void beforeGroups() {
        System.out.println("Before Smoke Group");
    }

    // Executes after groups
    @AfterGroups("smoke")
    public void afterGroups() {
        System.out.println("After Smoke Group");
    }

    // First test case
    @Test(priority = 1)
    public void loginTest() {
        System.out.println("Login Test");
    }

    // Test with group
    @Test(priority = 2, groups = {"smoke"})
    public void homePageTest() {
        System.out.println("Home Page Test");
    }

    // Dependent test
    @Test(priority = 3, dependsOnMethods = "loginTest")
    public void searchTest() {
        System.out.println("Search Test");
    }

    // Disabled test
    @Test(enabled = false)
    public void skipTest() {
        System.out.println("This Test is Skipped");
    }

    // Test with timeout
    @Test(timeOut = 2000)
    public void timeoutTest() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Timeout Test Passed");
    }

    // Test expected exception
    @Test(expectedExceptions = ArithmeticException.class)
    public void exceptionTest() {
        @SuppressWarnings("unused")
		int a = 10 / 0;
        
    }
}