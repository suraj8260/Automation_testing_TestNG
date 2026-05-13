package grouping;
import org.testng.annotations.Test;

public class PaymentsTest {

    @Test(priority = 1, groups = {"smoke","regression", "functional"})
    void paymentInRupees() {
        System.out.println("Payments in rupees");
    }

    @Test(priority = 2, groups = {"smoke", "regression", "functional"})
    void paymentInDollars() {
        System.out.println("Payments in dollars");
    }
}