package hybridProjectBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import Hybridutils.ReadExcel;
import hybridSeleniumBase.HybridSeleniumBaseClass;


public class HybridProjectSpecificMethods extends HybridSeleniumBaseClass {
		
	//public RemoteWebDriver driver;

	/*public HybridProjectSpecificMethods() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}*/
	
	
	@BeforeMethod
	public void browseropen() {
		startApp("chrome", "http://leaftaps.com/opentaps/");
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/");*/
		//Wrongly typed method: return new HybridLogin(driver);
	}
			
	@AfterMethod
	public void closeBrowser() {
		close();
	}
	
	@DataProvider(name="getdata")
	public String[][] fetchdata() throws IOException {
		String[][] data = ReadExcel.dataset();
		return data;
	}
	
}
