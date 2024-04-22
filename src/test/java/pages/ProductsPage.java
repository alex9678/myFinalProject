package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class ProductsPage extends AppBasePage {
	@FindBy(css = ".product_sort_container")
	private WebElement selectBtn;
	@FindBy(css = ".inventory_item")
	private List<WebElement> areaList;

	public ProductsPage(WebDriver driver) {
		super(driver);

	}

	@Step("Choose a specific Products")
	public void chooseProduct(String name) {
		for (WebElement area : areaList) {
			WebElement titleLink = area.findElement(By.cssSelector(".inventory_item_name"));
			if (titleLink.getText().equalsIgnoreCase(name)) {
				click(titleLink);
				break;

			}

		}
	}

	@Step("Add to Cart : {productName}")
	public void addToCart(String name) {
		for (WebElement area : areaList) {
			WebElement titleLink = area.findElement(By.cssSelector(".inventory_item_name"));
			if (titleLink.getText().equalsIgnoreCase(name)) {
				WebElement addBtn = area.findElement(By.cssSelector(".btn.btn_primary"));
				click(addBtn);

				break;

			}

		}
	}

	@Step("Sort products added")
	public void select(String name) {
		Select s = new Select(selectBtn);
		s.selectByValue(name);

	}
}