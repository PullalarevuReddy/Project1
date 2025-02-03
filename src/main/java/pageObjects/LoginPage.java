package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="userEmail")
	WebElement txtEmail;
	
	@FindBy(id="userPassword")
	WebElement txtPassword;
	
	@FindBy(id="login")
	WebElement txtButton;
	By elementToAppear=By.cssSelector(".mb-3");
	
	@FindBy(css=".ng-tns-c4-2.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error")
	WebElement errorMessage;
	

	
	//@Action class
	public ProductCatalouge launchApp(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		txtButton.click();
		waitForElementToAppear(elementToAppear);
		ProductCatalouge  productCatalouge=new ProductCatalouge(driver);
		return productCatalouge;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorInfo() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
	
	

}
