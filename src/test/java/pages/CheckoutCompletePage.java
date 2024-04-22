package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckoutCompletePage extends AppBasePage {
	@FindBy(css = ".btn.btn_primary ")
	private WebElement backBtn;
	
	@FindBy(css= "#header_container .title")
	private WebElement completeOrderMsg;

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);

	}
    @Step("Back to cart")
	public void back() {
		click(backBtn);
	}
    
    ///VALIDATION functions:
    @Step("Check if the page that we are on is order complete page ")
    public boolean isInOrderComplete() {
    	return getText(completeOrderMsg).endsWith("Complete!");
    }

}
