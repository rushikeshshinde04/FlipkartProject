package utilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility1 {
	

	
	public static void moveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).pause(2000).build().perform();
	}

	public static void moveByOffset(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(100,100).release().build().perform();
	}

	public static boolean isElementVisible (WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

	}
	
	public static List<String> getMultipleDataFromExcel(int firstRow, int lastRow) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\Rushi\\Desktop\\Products.xlsx");
		List<String> dataList = new ArrayList<String>();
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet2");
		for(int i=firstRow; i<=lastRow;i++)
		{
			try
			{
				String stringData = sheet.getRow(i).getCell(1).getStringCellValue();
				dataList.add(stringData);
			}catch(Exception e)
			{
				long intData = (long) sheet.getRow(i).getCell(1).getNumericCellValue();
				String string = String.valueOf(intData);
				dataList.add(string);
			}
		}
		return dataList;
		
	}
	
	public String screenCapture(WebDriver driver) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		String path = "screenshot.jpeg";
		File Dest = new File("screenshot.jpeg");
		
		FileHandler.copy(file, Dest);
		
		return path;
	}
	
	public String getConfigData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("Configuration\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
		
	}


}
