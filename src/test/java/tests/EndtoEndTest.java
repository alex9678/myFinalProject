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
@Epic("Receipt Examination")
@Feature("Buy Product End to End")
@Severity(SeverityLevel.CRITICAL)


public class EndtoEndTest extends BaseTest {
	
	@Story("Buy Product End To End")
	@Description("Complete a full process of buying a product from start to end")
	@Test(description = "End to End test")
	public void tc01_endtoend() {
		productsPage.addToCart("Sauce Labs Bike Light");
		productsPage.addToCart("Sauce Labs Backpack");
		productsPage.addToCart("Sauce Labs Onesie");
		productsPage.goToCart();
		yourCartPage.checkout();
		checkInformationPage.fillform("Altx", "dfdfd", "727272");
		checkoutOverviewPage.finish();
		checkoutCompletePage.back();
		
	}
	@Story("ResetApp test")
	@Description("remove all products from cart test")
	@Test(description = "ResetApp test")
	public void tc02_entoend2() {
		productsPage.addToCart("Sauce Labs Bike Light");
		productsPage.resetAppState();
		productsPage.addToCart("Sauce Labs Backpack");
		productsPage.resetAppState();
		productsPage.addToCart("Sauce Labs Onesie");
		productsPage.resetAppState();
		
		
	}
	


}
