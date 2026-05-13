package dependencyMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethodsExplanation {

    @Test(priority=1)
    void OpenApp() {
        // Simulating application launch
        Assert.assertTrue(true);
    }

    @Test(priority=2, dependsOnMethods = {"OpenApp"})
    void login() {
        // This test only runs if OpenApp() passes
        Assert.assertTrue(true);
    }

    @Test(priority=3, dependsOnMethods = {"login"})
    void search() {
        // This test only runs if login() passes
        Assert.assertTrue(true);
    }

    @Test(priority=4, dependsOnMethods = {"login", "search"})
    void advanceSearch() {
        // This test depends on both login() and search() passing
        Assert.assertTrue(true);
    }

    @Test(priority=5)
    void logout() {
        // Standard logout test
        Assert.assertTrue(true);
    }
}