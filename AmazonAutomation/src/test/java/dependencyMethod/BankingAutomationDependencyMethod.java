package dependencyMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankingAutomationDependencyMethod {

    @Test
    public void createAccount() {
        System.out.println("Step 1: Creating a new Savings Account...");
        // If account creation fails, all subsequent steps are useless
        Assert.assertTrue(true); 
    }

    @Test(dependsOnMethods = {"createAccount"})
    public void depositInitialAmount() {
        System.out.println("Step 2: Depositing ₹10,000...");
        // If deposit fails, transfer will fail due to zero balance
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"depositInitialAmount"})
    public void transferFunds() {
        System.out.println("Step 3: Transferring ₹5,000 to a beneficiary.");
    }

    @Test(dependsOnMethods = {"transferFunds"})
    public void checkMiniStatement() {
        System.out.println("Step 4: Verifying the transaction in Mini Statement.");
    }
}