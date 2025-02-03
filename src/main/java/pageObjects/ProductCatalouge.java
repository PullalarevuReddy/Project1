package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class ProductCatalouge extends AbstractComponents {
	WebDriver driver;
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By cartButton=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	By aniamate=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() {
		return products;
	}
	public WebElement actualProduct(String productName) {
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addToCart(String productName) {
		WebElement prod=actualProduct(productName);
		
		prod.findElement(cartButton).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(aniamate);
		addtoCartProduct();
	}

}
