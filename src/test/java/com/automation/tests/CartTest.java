package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ShopPage;

public class CartTest extends BaseTest {
	
	 private static final String STUFFED_FROG = "Stuffed Frog";
	    private static final String FLUFFY_BUNNY = "Fluffy Bunny";
	    private static final String VALENTINE_BEAR = "Valentine Bear";

    @Test
    public void validateCartCalculations() {
        HomePage homePage = new HomePage(driver);
        ShopPage shopPage = new ShopPage(driver);

        homePage.goToShopPage();

        addProductsToCart(shopPage);

        homePage.goToCartPage();

        CartPage cartPage = new CartPage(driver);

        validateIndividualPrices(cartPage);
        validateSubtotals(cartPage);
        validateTotal(cartPage);
    }

    private void addProductsToCart(ShopPage shopPage) {
        shopPage.buyProduct(STUFFED_FROG, 2);
        shopPage.buyProduct(FLUFFY_BUNNY, 5);
        shopPage.buyProduct(VALENTINE_BEAR, 3);
    }

    private void validateIndividualPrices(CartPage cartPage) {
        double individualFrogPrice = cartPage.getIndividualProductPrice(STUFFED_FROG);
        double individualBunnyPrice = cartPage.getIndividualProductPrice(FLUFFY_BUNNY);
        double individualBearPrice = cartPage.getIndividualProductPrice(VALENTINE_BEAR);

        Assert.assertEquals(individualFrogPrice, 10.99, 0.01, "Incorrect price for Stuffed Frog");
        Assert.assertEquals(individualBunnyPrice, 9.99, 0.01, "Incorrect price for Fluffy Bunny");
        Assert.assertEquals(individualBearPrice, 14.99, 0.01, "Incorrect price for Valentine Bear");
    }

    private void validateSubtotals(CartPage cartPage) {
        double individualFrogPrice = cartPage.getIndividualProductPrice(STUFFED_FROG);
        double individualBunnyPrice = cartPage.getIndividualProductPrice(FLUFFY_BUNNY);
        double individualBearPrice = cartPage.getIndividualProductPrice(VALENTINE_BEAR);

        double frogSubtotal = cartPage.getProductSubTotal(STUFFED_FROG);
        double bunnySubtotal = cartPage.getProductSubTotal(FLUFFY_BUNNY);
        double bearSubtotal = cartPage.getProductSubTotal(VALENTINE_BEAR);

        Assert.assertEquals(frogSubtotal, individualFrogPrice * 2, 0.01, "Incorrect subtotal for Stuffed Frog");
        Assert.assertEquals(bunnySubtotal, individualBunnyPrice * 5, 0.01, "Incorrect subtotal for Fluffy Bunny");
        Assert.assertEquals(bearSubtotal, individualBearPrice * 3, 0.01, "Incorrect subtotal for Valentine Bear");
    }

    private void validateTotal(CartPage cartPage) {
        double frogSubtotal = cartPage.getProductSubTotal(STUFFED_FROG);
        double bunnySubtotal = cartPage.getProductSubTotal(FLUFFY_BUNNY);
        double bearSubtotal = cartPage.getProductSubTotal(VALENTINE_BEAR);

        double expectedTotal = frogSubtotal + bunnySubtotal + bearSubtotal;
        double actualTotal = cartPage.getTotal();

        Assert.assertEquals(actualTotal, expectedTotal, 0.01, "Incorrect cart total");
    }
}