package allAnotation;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class SoftAssertionExample {

    @Test
    public void testDashboardUI() {
        // 1. Create an object of SoftAssert
        SoftAssert softAssert = new SoftAssert();

        System.out.println("--- Step 1: Verifying Logo ---");
        softAssert.assertTrue(false, "Logo is missing!"); // Fails, but continues

        System.out.println("--- Step 2: Verifying Welcome Message ---");
        softAssert.assertEquals("Welcome Admin", "Welcome User", "Greeting mismatch!"); // Fails, but continues

        System.out.println("--- Step 3: Verifying Logout Button ---");
        softAssert.assertTrue(true, "Logout button not found"); // Passes

        // 4. IMPORTANT: Collect and report all results
        // If you forget this line, the test will pass even if assertions failed!
        softAssert.assertAll();
    }
}