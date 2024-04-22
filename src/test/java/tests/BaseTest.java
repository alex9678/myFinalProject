package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CheckInformationPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.ItemPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import utils.Utils;

public class BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	ItemPage itemPage;
	YourCartPage yourCartPage;
	CheckInformationPage checkInformationPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CheckoutCompletePage checkoutCompletePage;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = Utils.getValue("url");
		driver.get(url);

		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		itemPage = new ItemPage(driver);
		yourCartPage = new YourCartPage(driver);
		checkInformationPage = new CheckInformationPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);

	}

	@BeforeClass
	public void setupLogin() {
		loginPage.login("standard_user", "secret_sauce");
	}

	@AfterClass
	public void tearDown() {
	}

}
