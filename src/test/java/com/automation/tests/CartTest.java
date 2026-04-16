package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ShopPage;
import org.testng.Assert;

public class CartTest extends BaseTest{

    @Test
    public void validateCartCalculations() {
    	HomePage homePage = new HomePage(driver);
    	homePage.goToShopPage();
    	ShopPage shopPage = new ShopPage(driver);
    	CartPage cartpage = new CartPage(driver);
    	
    	shopPage.buyProduct("Stuffed Frog", 2);
        shopPage.buyProduct("Fluffy Bunny", 5);
        shopPage.buyProduct("Valentine Bear", 3);
        
        homePage.goToCartPage();
        
        double individualFrogPrice = cartpage.getIndividualProductPrice("Stuffed Frog");
        double individualBunnyPrice = cartpage.getIndividualProductPrice("Fluffy Bunny");
        double individualBearPrice = cartpage.getIndividualProductPrice("Valentine Bear");
        
        Assert.assertEquals(individualFrogPrice, 10.99, 0.01);
        Assert.assertEquals(individualBunnyPrice, 9.99, 0.01);
        Assert.assertEquals(individualBearPrice, 14.99, 0.01);
        
        double frogSubtotal = cartpage.getProductSubTotal("Stuffed Frog");
        double bunnySubtotal = cartpage.getProductSubTotal("Fluffy Bunny");
        double bearSubtotal = cartpage.getProductSubTotal("Valentine Bear");
       
        
        Assert.assertEquals(frogSubtotal, individualFrogPrice * 2, 0.01);
        Assert.assertEquals(bunnySubtotal, individualBunnyPrice * 5, 0.01);
        Assert.assertEquals(bearSubtotal, individualBearPrice * 3, 0.01);
        
        double actualTotal = cartpage.getTotal();
        double expectedTotal = frogSubtotal + bunnySubtotal + bearSubtotal;
        
        Assert.assertEquals(actualTotal, expectedTotal, 0.01);
        
        
    }
}
