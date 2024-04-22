package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private String mainWindow;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}

	public WebDriver getDriver() {
		return driver;
	}

	void fillText(WebElement el, String text) {
		highlightElement(el, "yellow");
		waiting(300);
		el.clear();
		el.sendKeys(text);
	}

	void click(WebElement el) {
		highlightElement(el, "blue");
		waiting(300);
		waitForElementToBeClickable(el);
		el.click();
	}

	String getText(WebElement el) {
		highlightElement(el, "orange");
		return el.getText();
	}

	// waits
	void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	void waitForElementToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	void waitForElementToBeInVisible(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	void waiting(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	// New Tabs
	public void moveToNewWindow() {
		mainWindow = getDriver().getWindowHandle();
		Set<String> list = getDriver().getWindowHandles();
		for (String win : list) {
			getDriver().switchTo().window(win);
		}
	}

	public void moveBackToMainWindow() {
		getDriver().switchTo().window(mainWindow);
	}

	public void close() {
		driver.close();
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	private void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

}
