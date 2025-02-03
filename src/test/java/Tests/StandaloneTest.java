package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductCatalouge;
import testcomponents.BaseTest;

public class StandaloneTest extends BaseTest {
	@Test(dataProvider = "getData")
	public void launchApplication(HashMap<String, String> input) throws IOException {

		LoginPage loginPage = launchApp();

		loginPage.goTo();
		ProductCatalouge productCatalouge = loginPage.launchApp(input.get("email"), input.get("password"));
		productCatalouge.actualProduct(input.get("product"));
		productCatalouge.addToCart(input.get("product"));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap();

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
	/*
	 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
	 * "chakrireddy170@gmail.com"); map.put("password", "Chakri@1234");
	 * map.put("product", "ADIDAS ORIGINAL");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "chakrireddy170@gmail.com"); map1.put("password",
	 * "Chakri@1234"); map1.put("product", "ADIDAS ORIGINAL");
	 */

}
