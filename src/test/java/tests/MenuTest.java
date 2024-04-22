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
@Epic("Menu")
@Severity(SeverityLevel.CRITICAL)

public class MenuTest extends BaseTest {

	@Feature("Navigation")
	@Story("Navigate from cart to All Items")
	@Description("Verify navitating from Cart to All Items")
	@Test(description = "Cleaning Cart Button Test")
	public void tc01_menutest() {
		productsPage.chooseProduct("Sauce Labs Bike Light");
		itemPage.addToCart();
		itemPage.resetAppState();

	}

	@Feature("Navigation")
	@Story("Logout from Products Details page")
	@Description("Verify logout functionality from Product Details")
	@Test(description = "Back To HomePage Button Test")
	public void tc02_menutest2() {
		productsPage.addToCart("Sauce Labs Fleece Jacket");
		productsPage.goToCart();
		yourCartPage.backMenu();
		productsPage.logout();

	}

}
