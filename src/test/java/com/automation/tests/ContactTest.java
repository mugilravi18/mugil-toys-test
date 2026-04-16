package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.ContactPage;
import com.automation.pages.HomePage;

public class ContactTest extends BaseTest {

    @Test
    public void validateMandatoryFields() {
        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = new ContactPage(driver);

        homePage.goToContactPage();
        contactPage.clickSubmit();

        Assert.assertTrue(contactPage.isForenameErrorDisplayed());
        Assert.assertTrue(contactPage.isEmailErrorDisplayed());
        Assert.assertTrue(contactPage.isMessageErrorDisplayed());
        System.out.println("Forename error: " + contactPage.isForenameErrorDisplayed());
        System.out.println("Email error: " + contactPage.isEmailErrorDisplayed());
        System.out.println("Message error: " + contactPage.isMessageErrorDisplayed());

        contactPage.enterForename("TestUser");
        contactPage.enterEmail("TestUser1@test.com");
        contactPage.enterMessage("This is a test message");
        
        contactPage.clickSubmit();
        
      	Assert.assertTrue(contactPage.isForenameErrorGone());
        Assert.assertTrue(contactPage.isEmailErrorGone());
        Assert.assertTrue(contactPage.isMessageErrorGone());	
        System.out.println("Forename error: " + contactPage.isForenameErrorGone());
        System.out.println("Email error: " + contactPage.isEmailErrorGone());
        System.out.println("Message error: " + contactPage.isMessageErrorGone());
    }
}