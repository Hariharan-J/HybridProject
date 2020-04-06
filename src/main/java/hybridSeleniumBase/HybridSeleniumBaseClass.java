package hybridSeleniumBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Hybridutils.BasicReporter;
import hybridDesign.Browser;
import hybridDesign.Element;

public class HybridSeleniumBaseClass extends BasicReporter implements  Browser,Element {

		public RemoteWebDriver driver;
	
	public RemoteWebDriver startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			reportStep("Browser "+browser+ " is invoked", "pass");
		} catch (Exception e) {
			reportStep("Browser "+browser+ " is not invoked", "fail");
			throw new RuntimeException();			
		}
		return driver;
}

	public void close() {
		driver.close();
	}

	public String fetchtitle() {
		String title = null;
		try {
			title = driver.getTitle();
			System.out.println(title);
		} catch (WebDriverException e) {
			reportStep("Unknown exception on fetching title", "Fail");
			e.printStackTrace();
		}
		return title;
	}

	public WebElement locateElement(String ele, String value) {
		//WebElement eleid = null;
		try { 
		switch(ele.toLowerCase()) {
		case "id":
			WebElement eleid = driver.findElementById(value);
			return eleid;
		case "name":
			WebElement elename = driver.findElementByName(value);
			return elename;
		case "classname":
			WebElement eleclass = driver.findElementByClassName(value);
			return eleclass;
		case "linktext":
			WebElement elelink = driver.findElementByLinkText(value);
			return elelink;
		case "xpath":
			WebElement elexpath = driver.findElementByXPath(value);
			return elexpath;
		}
		reportStep("Locator "+ele+"is located", "Pass");
		}	
		/*try {
			if(ele.equalsIgnoreCase("id")) {
				eleid = driver.findElement(By.id(Value));
			}
		}*/ 
		catch (NoSuchElementException e) {
			reportStep("Locator "+ele+"is not located", "fail");
			throw new RuntimeException();
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public void clearandtype(String ele, String elevalue, String value) {
		try {
			WebElement element = locateElement(ele, elevalue);
			element.clear();
			element.sendKeys(value);
			reportStep("Locator "+ele+" is filled with "+value+" located", "pass");
		} catch (NoSuchElementException e) {
			reportStep("Locator "+ele+" is not filled with "+value+" located", "fail");
		} catch (Exception e) {
			System.out.println("Different exception");
	}
	
}

	@Override
	public void click(String ele, String value) {
		try {
			WebElement element = locateElement(ele, value);
			element.click();
			reportStep("Locator "+ele+" is clicked", "pass");
		} catch (NoSuchElementException e) {
			reportStep("Locator "+ele+" is not available", "fail");
		} catch (Exception e) {
			reportStep("Locator "+ele+" is not clicked", "fail");
		}	
	}

	@Override
	public void verifyEleText(String ele,String value,String inputtext) {
		try {
			String eleText = locateElement(ele, value).getText();
			if(eleText.contains(inputtext))
				reportStep("Element text updated as "+eleText, "pass");
			else
				reportStep("Element text not updated as "+eleText, "fail");
		} catch (NoSuchElementException e) {
			reportStep("Error: Element not  present", "fail"); 
		} catch (Exception e) {
			reportStep("Exception on verifying element text", "fail"); 
		}
		
	}

	@Override
	public void sleep() throws InterruptedException {
		Thread.sleep(5000);		
	}

	@Override
	public String fetchText(String ele,String value) {
		String eleText = null;
		try {
			eleText = locateElement(ele, value).getText();
			reportStep("Element text is "+eleText,"pass");
		} catch (NoSuchElementException e) {
			reportStep("Error: Element not  present","fail"); 
		} catch (WebDriverException e) {
			reportStep("cannot fetch text from webdriver exception","fail");
			e.printStackTrace();
		}catch (Exception e) {
			reportStep("Normal exception: cannot fetch text","fail");
			e.printStackTrace();
		}
		return eleText;	
	}
	

	@Override
	public boolean stringCompare(String s1, String s2) {
		boolean comp=false;
		try {
			if(s1.contains(s2)) {
				reportStep("Both the text are same","pass");
				comp=true;
			}	
			else
				reportStep("Both the text are not same","fail");
		} catch (Exception e) {
			reportStep("Normal exception: string comparison", "Fail");
			e.printStackTrace();
		}
		return comp;
	}

	@Override
	public String regexPickText(String s) {
		s = s.replaceAll("[^a-zA-Z]", "");
		return s;
	}
	
	public List<String> windowlist = null;
	@Override
	public List<String> getWindows() {
		try {
			Set<String> window = driver.getWindowHandles();
			windowlist = new ArrayList<String>(window);
		} catch (NoSuchWindowException e) {
			reportStep("Error: New window not present","fail");
		} catch (Exception e) {
			reportStep("Normal exception: get window list","fail");
			e.printStackTrace();
		}
		return windowlist;
	}

	@Override
	public void switchToWindows(int index) {
		try {
			List<String> winlist = getWindows();
			driver.switchTo().window(winlist.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("Error: New window not present","fail");
		} catch (Exception e) {
			reportStep("Normal exception: get window list","fail");
			e.printStackTrace();
		}
	}

	@Override
	public void alertAccept() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("Error: Alert not present","fail");
		} catch (Exception e) {
			reportStep("Normal exception:Alert","fail");
			e.printStackTrace();
		}
	}
	
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/screenshots/"+number+".jpg"));
		} catch (Exception e) {
			System.out.println("could not take snap");
			e.printStackTrace();
		}
		return number;
	}
}