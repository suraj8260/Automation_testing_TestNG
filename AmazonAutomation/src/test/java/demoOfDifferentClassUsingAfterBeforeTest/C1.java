package demoOfDifferentClassUsingAfterBeforeTest;

import org.testng.annotations.Test;

public class C1 {

	@Test(priority = 1)
	void search() {
		System.out.println("Search this in class 1!");
	}
	
	@Test(priority = 2)
	void advanceSearch() {
		System.out.println("Search Advance in class 1!");
	}
}
