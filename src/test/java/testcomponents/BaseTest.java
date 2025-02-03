package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseTest {
	public WebDriver driver;
	
	public WebDriver intializeDriver() throws IOException{
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\LENOVO\\Eclipse-workspacePractice\\RahulShettyFramework1\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}
public List<HashMap<String,String>> getJsonDataToMap() throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File("C:\\Users\\LENOVO\\Eclipse-workspacePractice\\RahulShettyFramework1\\src\\test\\java\\data\\Standalone.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
	}
	@BeforeMethod
	public LoginPage launchApp() throws IOException {
		driver=intializeDriver();
		LoginPage loginPage=new LoginPage(driver);
		return loginPage;
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
