package demoOfDifferentClassUsingAfterBeforeTest;

import org.testng.annotations.AfterTest;

public class C3 {

	@AfterTest
	void logout() {
		System.out.println("Logout is in class 3!");
	}

}
