package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends AppBasePage {
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;
	@FindBy(css = "#continue-shopping")
	private WebElement continueShoppingBtn;

	public YourCartPage(WebDriver driver) {
		super(driver);

	}

	public void checkout() {
		click(checkoutBtn);
	}

	public void back() {
		click(continueShoppingBtn);
	}

}
