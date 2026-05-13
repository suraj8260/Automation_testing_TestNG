package com.amazon.AmazonAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement para = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		System.out.println(para.getText());
		Thread.sleep(10);
		driver.quit();
	}
}
