package allAnotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionExample {

    @Test
    public void testLoginLogic() {
        String expectedTitle = "Dashboard";
        String actualTitle = "Login Page"; // Simulating a failure

        System.out.println("--- Step 1: Checking Page Title ---");
        
        // This is a Hard Assertion
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");

        // This line will NOT execute because the assertion above fails
        System.out.println("--- Step 2: This line will never be printed ---");
        
        Assert.assertTrue(10 > 5, "Math logic failed");
    }
}