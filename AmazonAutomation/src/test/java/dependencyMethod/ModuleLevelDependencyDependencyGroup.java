package dependencyMethod;
import org.testng.annotations.Test;

public class ModuleLevelDependencyDependencyGroup {

    // --- GROUP: Backend Services ---
    @Test(groups = "Backend")
    public void verifyServerHealth() {
        System.out.println("Backend: Server is responding (200 OK)");
    }

    @Test(groups = "Backend")
    public void verifyDatabaseHeartbeat() {
        System.out.println("Backend: Database connection is active");
    }

    // --- GROUP: User Authentication ---
    @Test(groups = "Auth", dependsOnGroups = "Backend")
    public void loginToPortal() {
        System.out.println("Auth: Logging into the banking portal.");
    }

    // --- GROUP: Main Transactions ---
    // This will only run if BOTH the 'Backend' and 'Auth' groups pass
    @Test(dependsOnGroups = {"Backend", "Auth"})
    public void performWireTransfer() {
        System.out.println("Transaction: Executing secure wire transfer.");
    }
}