package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class WebDriverManagement {
	private WebDriver driver = null;
	public WebDriverManagement(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebDriver startWebDriverInstance(String url, String browserType){
		switch (browserType) {
		case "gc":
			driver = new ChromeDriver();
			break;
		case "ff":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Incorrect browser_type=" + browserType);
			Assert.assertFalse(false);
			break;
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

	public void takeAScreenshot(){
		
	}

	public void closeBrowser(boolean takingScreenshotIfTestFailed){
		try {
			if (takingScreenshotIfTestFailed == true){
				System.out.println("Taking screenshot...");
				System.out.println("Not implemented!!!");
			}
		} finally {
			System.out.println("Closing browser...");
			driver.close();
		}
	}

	public void navigateTo(String url){
		driver.navigate().to(url);
	}


}
