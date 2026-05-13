package demoOfDifferentClassUsingAfterBeforeTest;

import org.testng.annotations.BeforeTest;

public class C2 {

	@BeforeTest
	void login() {
		System.out.println("Login is in class 2!");
	}
	
}
