package testClasses;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utilitypak.*;

public class Listener extends Base implements ITestListener {
	
	public void onTestSuccess(ITestResult result)
	{
	String TCname = result.getName();
	Reporter.log("This "+TCname+" method completed successfully", true);
	}
	
	public void onTestFailure(ITestResult result) {
		String TCname = result.getName();
		try {
			Reporter.log("Taking SS", true);
			Utility.captureScreenshot(driver, TCname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("This "+TCname+" method failed successfully", true);
	}
	
	public void onTestStart(ITestResult result) {
		String TCname = result.getName();
		Reporter.log("Class Name "+result.getTestClass(),true);
		Reporter.log("Method Name "+result.getMethod(),true);
		
		Reporter.log("Test "+TCname+" execution started", true);
	}
	
	public void onTestSkipped(ITestResult result) {
		String TCname = result.getName();
		Reporter.log("This "+TCname+" method has been skipped", true);
	}
}
