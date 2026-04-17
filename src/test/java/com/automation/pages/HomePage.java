package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "a[href='#/contact']")
    WebElement contactLink;

    @FindBy(css = "a[href='#/shop']")
    WebElement shopLink;

    @FindBy(css = "a[href='#/cart']")
    WebElement cartLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToContactPage() {
        wait.until(ExpectedConditions.visibilityOf(contactLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contactLink);
    }

    public void goToShopPage() {
        wait.until(ExpectedConditions.visibilityOf(shopLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", shopLink);
    }

    public void goToCartPage() {
        wait.until(ExpectedConditions.visibilityOf(cartLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLink);
    }
}