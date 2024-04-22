package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckoutOverviewPage extends AppBasePage {
	@FindBy(css = "#finish")
	private WebElement finishBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);

	}
    @Step("Finish the Order")
	public void finish() {
		click(finishBtn);
	}
    @Step("Back to product page")
	public void cancel() {
		click(cancelBtn);
	}

}
