package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Contact")
    WebElement contactLink;
    
    @FindBy(linkText = "Shop")
    WebElement shopLink;
    
    @FindBy(xpath = "//a[contains(@href,'#/cart')]")
    WebElement cartLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToContactPage() {
        contactLink.click();
    }
    
    public void goToShopPage() {
    	shopLink.click();
    }
    
    public void goToCartPage() {
    	cartLink.click();
    }
    
    
}