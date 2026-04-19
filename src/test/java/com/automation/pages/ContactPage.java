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
     WebDriverWait wait;
     
     public ContactPage(WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         PageFactory.initElements(driver,this);
     }

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
     

   
    public void clickSubmit() {
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
    	wait.until(ExpectedConditions.elementToBeClickable(forenameField)).sendKeys(name);
    }
//
    public void enterEmail(String email) {
    	wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }
//
    public void enterMessage(String msg) {
    	wait.until(ExpectedConditions.elementToBeClickable(messageField)).sendKeys(msg);
    }
    
    public boolean isEmailErrorGone() {
        return wait.until(ExpectedConditions.invisibilityOf(emailError));
    }
    
    public boolean isForenameErrorGone() {
    	return wait.until(ExpectedConditions.invisibilityOf(forenameError));
    }
    
    public boolean isMessageErrorGone() {
    	return wait.until(ExpectedConditions.invisibilityOf(messageError));
    }
    
    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }
    
    public String getSuccessMessageText() {
    	return successMessage.getText();
    }

}