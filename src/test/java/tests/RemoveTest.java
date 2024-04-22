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
@Feature("Remove Cart")
@Severity(SeverityLevel.NORMAL)

public class RemoveTest extends BaseTest {
	@Story("Remove Item from Product Details")
	@Description("Verify removing items from Products Details")
	@Test(description = "Remove Products Test")
	public void tc01_remove() {
		productsPage.addToCart("Sauce Labs Bike Light");
		productsPage.remove();
		productsPage.addToCart("Sauce Labs Fleece Jacket");
		productsPage.remove();
		productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
		productsPage.remove();
		productsPage.addToCart("Sauce Labs Backpack");
		productsPage.remove();
		productsPage.addToCart("Sauce Labs Bolt T-Shirt");
		productsPage.remove();
		productsPage.addToCart("Sauce Labs Onesie");
		productsPage.remove();

	}

	@Story("Remove Item From Product")
	@Description("Removing Products from Item Page")
	@Test(description = "Remove Products From Item Page Test")
	public void tc02_remove2() {
		productsPage.chooseProduct("Sauce Labs Bike Light");
		itemPage.addToCart();
		itemPage.remove();
		productsPage.chooseProduct("Sauce Labs Fleece Jacket");
		itemPage.addToCart();
		itemPage.remove();
		productsPage.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		itemPage.addToCart();
		itemPage.remove();
		productsPage.chooseProduct("Sauce Labs Backpack");
		itemPage.addToCart();
		itemPage.remove();
		productsPage.chooseProduct("Sauce Labs Bolt T-Shirt");
		itemPage.addToCart();
		itemPage.remove();
		productsPage.chooseProduct("Sauce Labs Onesie");
		itemPage.addToCart();
		itemPage.remove();

	}

}
