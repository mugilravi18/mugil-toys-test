package com.automation.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {
	WebDriver driver;
	
	public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
	
	public void buyProduct(String productName, int quantity) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	WebElement buyButton = driver.findElement(By.xpath("//h4[text()='" + productName + "']/following-sibling::p/a"));
		for (int i = 0; i < quantity; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(buyButton)).click();
		}
    }
}
