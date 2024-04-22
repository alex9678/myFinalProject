package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AppBasePage extends BasePage {
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement closeBtn;
	@FindBy(css = "#inventory_sidebar_link")
	private WebElement allItemBtn;
	@FindBy(css = ".btn.btn_secondary")
	private WebElement removeBtn;
	@FindBy(css = "#reset_sidebar_link")
	private WebElement resetAppBtn;
	@FindBy(css = ".shopping_cart_container")
	private WebElement cartBtn;
	@FindBy(css = ".shopping_cart_badge")
	private WebElement cartItemsLabel;

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logoutBtn;

	public AppBasePage(WebDriver driver) {
		super(driver);

	}
    @Step("Go to menu")
	public void backMenu() {
		click(menuBtn);
		waiting(1000);
		click(allItemBtn);
	}

	public void remove() {
		click(removeBtn);
	}
    @Step("Clean cart from products")
	public void resetAppState() {
		click(menuBtn);
		waiting(1000);
		click(resetAppBtn);
		waiting(1000);
		click(closeBtn);
	}

	@Step("Go to Cart")
	public void goToCart() {
		click(cartBtn);
	}

	@Step("Log Out")
	public void logout() {
		click(menuBtn);
		waiting(1000);
		click(logoutBtn);

	}
    @Step("Check how many items in cart")
	public int getItemsInCart() {
		String s = "";
		try {
			s = getText(cartItemsLabel);
		} catch (Exception e) {
			return 0;
		}
		int i = Integer.parseInt(s);
		return i;
	}

}
