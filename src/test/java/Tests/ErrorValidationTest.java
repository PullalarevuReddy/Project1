package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest {
	@Test
	public void launchApplication() throws IOException {

		LoginPage loginPage = launchApp();
		loginPage.goTo();
		loginPage.launchApp("chakrireddy171@gmail.com", "Chakri@1234");
		Assert.assertEquals("Incorrect email or password", loginPage.errorInfo());

	}

}
