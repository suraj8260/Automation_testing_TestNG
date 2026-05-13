package TakeScreenshotOfPageWhenItFail;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScreenShotIfFail {

    WebDriver driver;

    @BeforeClass
    void setup() {

        driver = new ChromeDriver();
        driver.get("https://academybugs.com/find-bugs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    void show1() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement photo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Dark Grey Jeans')]")));
        boolean status = photo.isDisplayed();
        System.out.println("jeans visible! : " + status);
    }

    @Test(priority = 2)
    void addCart1() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("ec_add_to_cart_4")));
        cart.click();
    }

    @Test(priority = 5)
    void checkChat() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement check = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='View Cart']")));
        check.click();
    }

    @Test(priority = 6)
    void quantity() throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Quantity field
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[contains(@class,'ec_quantity')])[1]")));
        // Plus button
        WebElement plus = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='+'])[1]")));
        // Click plus button 4 times
        plus.click();
        plus.click();
        plus.click();
        plus.click();

        // ==================================
        // SCREENSHOT IMMEDIATELY AFTER PLUS
        // ==================================

        File beforeShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String beforePath = System.getProperty("user.dir")+ "/screenshots/BeforeUpdate.png";

        FileHandler.copy(beforeShot, new File(beforePath));

        System.out.println("Before Update Screenshot Taken");

        // Expected quantity
        int expectedQty = 5;

        // Update button
        WebElement update = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'ec_cartitem_update')]")));
        // Click update
        update.click();

        // ====================================
        // SCREENSHOT IMMEDIATELY AFTER UPDATE
        // ====================================

        File afterShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String afterPath = System.getProperty("user.dir")+ "/screenshots/AfterUpdate.png";

        FileHandler.copy(afterShot, new File(afterPath));

        System.out.println("After Update Screenshot Taken");

        // Wait for updated value
        wait.until(driver ->quantityField.getAttribute("value").equals("5"));

        // Actual quantity
        int actualQty = Integer.parseInt(quantityField.getAttribute("value"));

        System.out.println("Expected Quantity : " + expectedQty);
        System.out.println("Actual Quantity   : " + actualQty);

        SoftAssert softAssert = new SoftAssert();

        // Validation
        if (actualQty != expectedQty) {

            File failShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String failPath = System.getProperty("user.dir") + "/screenshots/QuantityMismatch.png";

            FileHandler.copy(failShot, new File(failPath));

            System.out.println("Failure Screenshot Saved");

            softAssert.fail("Quantity mismatch! Expected : " + expectedQty + " but Found : " + actualQty);
        }

        softAssert.assertAll();
    }    
    @AfterClass
    void close() {
    	driver.quit();
    }
}