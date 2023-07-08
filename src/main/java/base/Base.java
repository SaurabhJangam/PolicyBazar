package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utilitypak.*;

public class Base {
	
	protected static WebDriver driver;
	

	public void launchBrowser() throws IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility.readPropertyFile("URL"));
		Reporter.log("Lauching browser..", true);

	}

	public void closeBrowser() {
		driver.quit();
		Reporter.log("Closing browser..", true);
	}

}
