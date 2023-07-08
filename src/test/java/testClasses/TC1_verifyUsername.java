package testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pomClasses.PolicyBazaarLoginPage;
import pomClasses.PolicyBazaarMyAccountPage;
import utilitypak.Utility;


public class TC1_verifyUsername extends Base {
	
	PolicyBazaarLoginPage login;
	PolicyBazaarMyAccountPage myAcc;

	@BeforeClass
	public void launchPolicyBazar() throws IOException {
		launchBrowser();
		login = new PolicyBazaarLoginPage(driver);
		myAcc = new PolicyBazaarMyAccountPage(driver);
	}

	@BeforeMethod
	public void signInToPolicyBazar() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Utility.implicitWait(driver,1000);
		login.clickOnSignInButton();
		Utility.implicitWait(driver,1000);
		login.enterMobNumber("7972577435");
		Utility.implicitWait(driver,1000);
		login.clickOnSignInWithPasswordButton();
		Utility.implicitWait(driver,1000);
		login.enterPassword(Utility.raedExcelData(0,1));
		Utility.implicitWait(driver,1000);
		login.clickOnSignInButton2();
		Utility.implicitWait(driver,1000);
		login.clickOnMyAccount();
		Utility.implicitWait(driver,1000);
		login.clickOnMyProfile();
		Utility.implicitWait(driver,1000);
//		Switch to My Account Page window
		Set<String> allWinID = driver.getWindowHandles();
		ArrayList<String> l = new ArrayList<String>(allWinID);
		driver.switchTo().window(l.get(1));
//		create object of my Account page
		Thread.sleep(5000);
	}
	
	
	@Test
	public void verifyUserName() throws EncryptedDocumentException, IOException {
		
		Assert.assertEquals(myAcc.getUsername(),Utility.raedExcelData(0, 2),"Username verification failed");
		
	}
	
	@AfterMethod
	public void logoutPolicybazar() {
		myAcc.clickLogout();
	}
	
	@AfterClass
	public void closePolicyBazar() {
		
		closeBrowser();

	}

}
