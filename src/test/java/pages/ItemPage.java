package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ItemPage extends AppBasePage {
	@FindBy(css= ".btn.btn_primary")
	private WebElement addToCartBtn;
	@FindBy(css= "#back-to-products")
	private WebElement backBtn;

	public ItemPage(WebDriver driver) {
		super(driver);
		
	}
	@Step("add the specific product to cart")
	public void addToCart() {
		click(addToCartBtn);
		
	}
	@Step("back to main products page")
	public void back() {
		click(backBtn);
	}

}
