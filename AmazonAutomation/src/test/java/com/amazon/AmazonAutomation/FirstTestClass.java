package com.amazon.AmazonAutomation;

import org.testng.annotations.Test;

public class FirstTestClass {

//	open app
//	login app
//	logout app
	
	@Test(priority = 1)
	void open() {
		System.out.println("Open the page!");
	}
	
	@Test(priority = 2)
	void login() {
		System.out.println("Login to the page!");
	}
	  
	@Test(priority = 3)
	void logout() {
		System.out.println("Logout from the page!");
	}
}
