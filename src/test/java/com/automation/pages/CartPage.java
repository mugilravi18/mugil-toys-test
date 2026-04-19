package com.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	 WebDriver driver;

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public double getIndividualProductPrice(String productName) {
	    	String priceXpath = "//tr[td[normalize-space()='" + productName + "']]/td[2]";
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        String price = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath(priceXpath)
	        )).getText();

	        return convertPrice(price);
	    }
	    
	    public int getProductQuantity(String productName) {
	    	   String quantityXpath = "//tr[td[normalize-space()='" + productName + "']]/td[3]/input";
	    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        String quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath(quantityXpath)
		        )).getAttribute("value");
	    	       return Integer.parseInt(quantity);
	    }
	    
	    public double getProductSubTotal(String productName) {
	    	  String ProductSubTotalXpath = "//tr[td[normalize-space()='" + productName + "']]/td[4]";
	    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        String subTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath(ProductSubTotalXpath)
		        )).getText();
	    	       return convertPrice(subTotal);
	    }
	    
	    public double getTotal() {
	        String total = driver.findElement(By.xpath("//strong[contains(normalize-space(),'Total')]"))
	                             .getText().replace("Total: ", "");
	        return convertPrice(total);
	    }
	    
	    
	    
	    private double convertPrice(String text) {
	        return Double.parseDouble(text.replace("$", ""));
	    }
}
