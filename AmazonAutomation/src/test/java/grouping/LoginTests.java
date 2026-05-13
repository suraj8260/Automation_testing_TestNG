package grouping;
import org.testng.annotations.Test;

public class LoginTests {

    @Test(priority = 1, groups = {"smoke"})
    void loginByEmail() {
        System.out.println("This is login by email");
    }

    @Test(priority = 2, groups = {"smoke"})
    void loginByFacebook() {
        System.out.println("This is login by facebook");
    }

    @Test(priority = 3, groups = {"smoke"})
    void loginByTwitter() {
        System.out.println("This is login by twitter");
    }
}