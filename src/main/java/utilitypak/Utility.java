package utilitypak;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void implicitWait(WebDriver driver,long waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	}

	
	public static void captureScreenshot(WebDriver driver,String scName ) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Velocity\\policybazar\\screenShots\\"+scName+".png");
        FileHandler.copy(source, dest);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		
	}
	
	public static String raedExcelData(int rowNum,int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream myFile= new FileInputStream("D:\\Velocity\\policybazar\\inputDataExcel\\PolicyData.xlsx");
		String svalue = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(rowNum).getCell(colNum).getStringCellValue();
		return svalue;
	}
	
	public static String readPropertyFile(String key) throws IOException {
		Properties prop =new Properties();
		FileInputStream myFile = new FileInputStream("D:\\Velocity\\selniumClass\\myProperty.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		return value;
	}
	
	

}
