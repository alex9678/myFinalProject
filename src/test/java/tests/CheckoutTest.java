package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Owner("Alex sc")
@Epic ("Checkout")
@Feature("User checkout Functionality")
@Severity(SeverityLevel.CRITICAL)


public class CheckoutTest extends BaseTest {
    @Story("Test fill form with wrong login")
    @Description("User cannot proceed with checkout without providing a FirstName,LastName, Zip")
	@Test(description = "FillForm Test", dataProvider = "getData")
	public void tc01_fillform(String firstName, String lastName, String zip, String expected) {
		productsPage.chooseProduct("Sauce Labs Bike Light");
		productsPage.goToCart();
		yourCartPage.checkout();
		checkInformationPage.fillform(firstName, lastName, zip);
		String actual = checkInformationPage.getErrotMsg();
		Assert.assertEquals(actual, expected);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "", "dfdfdf", "334343", "Error: First Name is required" },
				{ "standart_user", "", "33434", "Error: Last Name is required" },
				{ "standart_user", "secret_sauce", "", "Error: Postal Code is required" },
				{ "standart_user", "34374637", "", "dfdfdfd" }, { "standart_user", "fdfdf", "72727", "" },

		};
		return data;
	}

	@Test(description = "Checkout Test")
	public void tc02_checkout() {
		productsPage.addToCart("Sauce Labs Bike Light");
		productsPage.addToCart("Sauce Labs Fleece Jacket");
		productsPage.addToCart("Sauce Labs Bolt T-Shirt");
		productsPage.goToCart();
		yourCartPage.checkout();
		checkInformationPage.fillform("AAA", "FDFDF", "727272");
		checkoutOverviewPage.cancel();
		productsPage.goToCart();
		yourCartPage.checkout();
		checkInformationPage.fillform("AAA", "ALAL", "93939");
		

	}

}
