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
@Epic("Enhance Shopping Experience")
@Feature("Products Management")
@Severity(SeverityLevel.MINOR)

public class SortListTest extends BaseTest {

	@Story("Sort Items")
	@Description("As a User when I Sort By Their Names. alphbetical and reverse")
	@Test(description = "SortList Test")
	public void tc01_Select() {
		productsPage.select("hilo");
		productsPage.select("lohi");
		productsPage.select("az");
		productsPage.select("za");
	}

}
