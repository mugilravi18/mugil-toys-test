package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.ContactPage;
import com.automation.pages.HomePage;

public class SuccessTest extends BaseTest{
	int count = 1;
	
	@Test(invocationCount = 5)
	public void validateSuccessMessage() {
		 HomePage homePage = new HomePage(driver);
	     ContactPage contactPage = new ContactPage(driver);
	     
	     homePage.goToContactPage();
	     
	     String userName = "TestUser" + count;
	     String email = "TestUser" + count + "@test.com";
	     count ++;
	     
	     contactPage.enterForename(userName);
	     contactPage.enterEmail(email);
	     contactPage.enterMessage("This is a test message");
	     
	     contactPage.clickSubmit();
	     Assert.assertTrue(contactPage.isSuccessMessageDisplayed());
	     System.out.println("test message for testing123");
	     String expectedMessage = contactPage.getSuccessMessageText();
	     System.out.println("test message for testing456");
	     System.out.println("++++++" + expectedMessage);
	     Assert.assertTrue(expectedMessage.contains("we appreciate your feedback"));
	     Assert.assertTrue(expectedMessage.contains(userName));
	}
}
