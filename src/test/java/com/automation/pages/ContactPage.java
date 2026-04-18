package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage {

     WebDriver driver;

     @FindBy(xpath = "//a[contains(@class,'btn-contact btn')]")
     WebElement submitbtn;


     
     @FindBy(id = "forename")
     WebElement forenameField;
     
     @FindBy(id = "email")
     WebElement emailField;
     
     @FindBy(id = "message")
     WebElement messageField;
     
     
     @FindBy(id = "forename-err")
     WebElement forenameError;
     
     @FindBy(id = "email-err")
     WebElement emailError;
     
     @FindBy(id = "message-err")
     WebElement messageError;
     
     @FindBy(xpath = "//div[@class = 'alert alert-success']")
     WebElement successMessage;
     

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   
    public void clickSubmit() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(submitbtn)).click();
    }

    public boolean isForenameErrorDisplayed() {
        return forenameError.isDisplayed();
    }
//
    public boolean isEmailErrorDisplayed() {
        return emailError.isDisplayed();
    }
//
    public boolean isMessageErrorDisplayed() {
        return messageError.isDisplayed();
    }
//
    public void enterForename(String name) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(forenameField)).sendKeys(name);
    }
//
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }
//
    public void enterMessage(String msg) {
       messageField.sendKeys(msg);
    }
    
    public boolean isEmailErrorGone() {
    	 return new WebDriverWait(driver, Duration.ofSeconds(10))
    	            .until(ExpectedConditions.invisibilityOf(emailError));
    }
    
    public boolean isForenameErrorGone() {
    	return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(forenameError));
    }
    
    public boolean isMessageErrorGone() {
    	return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(messageError));
    }
    
    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }
    
    public String getSuccessMessageText() {
    	return successMessage.getText();
    }

}