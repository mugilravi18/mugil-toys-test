package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.ContactPage;
import com.automation.pages.HomePage;

public class SuccessTest extends BaseTest {

    int count = 1;

    @Test(invocationCount = 5)
    public void validateSuccessMessage() {
        HomePage homePage = new HomePage(driver);

        homePage.goToContactPage();

        ContactPage contactPage = new ContactPage(driver);

        String userName = generateUserName();
        String email = generateEmail(userName);

        fillContactForm(contactPage, userName, email);
        submitForm(contactPage);
        validateSuccessMessage(contactPage, userName);
    }

    private String generateUserName() {
        String userName = "TestUser" + count;
        count++;
        return userName;
    }

    private String generateEmail(String userName) {
        return userName + "@test.com";
    }

    private void fillContactForm(ContactPage contactPage, String userName, String email) {
        contactPage.enterForename(userName);
        contactPage.enterEmail(email);
        contactPage.enterMessage("This is a test message");
    }

    private void submitForm(ContactPage contactPage) {
        contactPage.clickSubmit();
    }

    private void validateSuccessMessage(ContactPage contactPage, String userName) {
        Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "Success message should be displayed");

        String actualMessage = contactPage.getSuccessMessageText();

        Assert.assertTrue(actualMessage.contains("we appreciate your feedback"),
                "Success message does not contain the appreciation text");
        Assert.assertTrue(actualMessage.contains(userName),
                "Success message does not contain the user's name");
    }
}