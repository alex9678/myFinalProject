package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckInformationPage extends BasePage {
	@FindBy(css = "#first-name")
	private WebElement firstNameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement zipField;
	@FindBy(css = "#continue")
	private WebElement continueBtn;
	@FindBy(css = ".error-message-container.error")
	private WebElement errorLabel;

	public CheckInformationPage(WebDriver driver) {
		super(driver);

	}
    @Step("Entered First name :{fname}, Last name: {name}, Zip number: {zipName} at Checkout stage ")
	public void fillform(String firstName, String lastName, String zip) {
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(zipField, zip);
		click(continueBtn);

	}
    ///VALIDATION functions
    @Step("return the ErrorMsg in the checkout page")
	public String getErrotMsg() {
		return getText(errorLabel);
	}

}
