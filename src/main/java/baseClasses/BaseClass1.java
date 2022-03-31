package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	
	public static WebDriver getChromeDriver(String a) 
	{
		if(a.equals("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			
			
			//System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();// To open chrome browser, UpCasting

			//driver.manage().deleteAllCookies();
			
			driver.get("https://www.flipkart.com/");//To open this site in browser
			
			driver.manage().window().maximize();
			
			return driver;

		}
		else
		{
			WebDriverManager.firefoxdriver().setup();

			
				//System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");

				WebDriver driver = new FirefoxDriver();// To open Firefox browser, UpCasting

				driver.get("https://www.flipkart.com/");//To open this site in browser
				
				driver.manage().window().maximize();
				
				return driver;
			}
		}

}
