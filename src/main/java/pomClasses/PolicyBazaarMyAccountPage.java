package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PolicyBazaarMyAccountPage {
	
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
	@FindBy(className = "h_l") private WebElement logOutButton;
	
	
	public PolicyBazaarMyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void validateUserName() {
		
		String expectedName ="Saurabh Jangam";
		String actualName=  userName.getText();
		if(expectedName.contains(actualName)) {
			System.out.println("Actual and Expected user Names are matching TC is Passed");
		}else {
			System.out.println("Actual and Expected user Names are not matching TC is Failed");
		}	
	}
	
	public void validateUserName(String expectedName) {
		String actualName=  userName.getText();
		if(expectedName.contains(actualName)) {
			System.out.println("Actual and Expected user Names are matching TC is Passed");
		}else {
			System.out.println("Actual and Expected user Names are not matching TC is Failed");
		}	
	}
	
	public String getUsername() {
		Reporter.log("Verifing Username", true);
		String actualName=  userName.getText();
		return actualName;
	}
	
	public void clickLogout() {
		logOutButton.click();
	}

}
