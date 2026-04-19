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

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a[href='#/contact']")
    private WebElement contactLink;

    @FindBy(css = "a[href='#/shop']")
    private WebElement shopLink;

    @FindBy(css = "a[href='#/cart']")
    private WebElement cartLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void goToContactPage() {
        click(contactLink);
    }

    public void goToShopPage() {
        click(shopLink);
    }

    public void goToCartPage() {
        click(cartLink);
    }

    private void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            // fallback to JS click when the normal click is not able to pick up the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}