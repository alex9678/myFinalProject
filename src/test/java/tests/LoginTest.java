package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Owner("Alex sc")
@Epic("User Authentication")
@Feature("Login")
@Severity(SeverityLevel.CRITICAL)

public class LoginTest extends BaseTest {
	@Override
	public void setupLogin() {
		loginPage.login("standard_user", "secret_sauce");
	}

	@Story("Failed Login Scenarios")
	@Description("Verify message for applying only password")
	@Test(description = "Login with Valid user and Invalid password", dataProvider = "getData")
	public void tc01_loginFailed(String user, String password, String expected) {
		loginPage.login(user, password);
		String actual = loginPage.getErrorMsg();
		Assert.assertEquals(actual, expected);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = {
				{ "standart", "1234", "Epic sadface: Username and password do not match any user in this service" },
				{ "standart_user", "1234", "Username and password do not match any user in this service" },
				{ "standart_user", "secret_sauce", "Lo Tov" }, { "standart_user", "!@#@!#!@#", "you got error" },
				{ "standart_user", "secret_sauce", "Lo Tov" }, { "standart_user", "!@#@!#!@#", "you got error" },
				{ "standart_user", "secret_sauce", "Lo Tov" }, { "standart_user", "!@#@!#!@#", "you got error" }

		};
		return data;
	}

	@Test(description = "Login Passed Test")
	public void tc02_loginPassed() {
		loginPage.login("standard_user", "secret_sauce");
	}

	@Test(description = "Logout Test")
	public void tc_03logout() {
		productsPage.logout();
	}

}
