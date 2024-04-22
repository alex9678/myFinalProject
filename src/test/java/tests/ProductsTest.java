package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Owner("Alex sc")
@Epic("Shopping Cart")
@Feature("Add To Cart Through Product Window")
@Severity(SeverityLevel.NORMAL)


public class ProductsTest extends BaseTest {
	
	
	@Story("Add Product")
	@Description("Verify adding a product to the cart through the product window")
	@Test(description = "add Products Test")
	public void tc01_addProducts() {
		productsPage.addToCart("Sauce Labs Bike Light");
		productsPage.addToCart("Sauce Labs Fleece Jacket");
		productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
		productsPage.addToCart("Sauce Labs Backpack");
		productsPage.addToCart("Sauce Labs Bolt T-Shirt");
		productsPage.addToCart("Sauce Labs Onesie");
		productsPage.resetAppState();
		
	}
	@Story("Add products from item page")
	@Description("Add products from item page to cart")
	@Test(description = "add Products from Item Page Test")
	public void tc02_addProducts2() {
		productsPage.chooseProduct("Sauce Labs Bike Light");
		itemPage.addToCart();
		itemPage.back();
		productsPage.chooseProduct("Sauce Labs Fleece Jacket");
		itemPage.addToCart();
		itemPage.back();
		productsPage.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		itemPage.addToCart();
		itemPage.back();
		productsPage.chooseProduct("Sauce Labs Backpack");
		itemPage.addToCart();
		itemPage.back();
		productsPage.chooseProduct("Sauce Labs Bolt T-Shirt");
		itemPage.addToCart();
		itemPage.back();
		productsPage.chooseProduct("Sauce Labs Onesie");
		itemPage.addToCart();
		itemPage.back();
	}

}
