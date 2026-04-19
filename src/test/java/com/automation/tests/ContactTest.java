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

        homePage.goToContactPage();

        ContactPage contactPage = new ContactPage(driver);

        submitEmptyForm(contactPage);
        validateErrorsAreDisplayed(contactPage);

        fillMandatoryFields(contactPage);
        contactPage.clickSubmit();

        validateErrorsAreGone(contactPage);
    }

    private void submitEmptyForm(ContactPage contactPage) {
        contactPage.clickSubmit();
    }

    private void validateErrorsAreDisplayed(ContactPage contactPage) {
        Assert.assertTrue(contactPage.isForenameErrorDisplayed(), "Forename error should be displayed");
        Assert.assertTrue(contactPage.isEmailErrorDisplayed(), "Email error should be displayed");
        Assert.assertTrue(contactPage.isMessageErrorDisplayed(), "Message error should be displayed");
    }

    private void fillMandatoryFields(ContactPage contactPage) {
        contactPage.enterForename("TestUser");
        contactPage.enterEmail("TestUser1@test.com");
        contactPage.enterMessage("This is a test message");
    }

    private void validateErrorsAreGone(ContactPage contactPage) {
        Assert.assertTrue(contactPage.isForenameErrorGone(), "Forename error should disappear");
        Assert.assertTrue(contactPage.isEmailErrorGone(), "Email error should disappear");
        Assert.assertTrue(contactPage.isMessageErrorGone(), "Message error should disappear");
    }
}