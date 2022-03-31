package testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import baseClasses.BaseClass1;
import pomClasses.HomePage;
import pomClasses.LoginPage1;
import pomClasses.ProfilePage1;

 

public class AddNewAddress {
	
	WebDriver driver;
	LoginPage1 lp;
	HomePage hp;
	ProfilePage1 pp;
	
	ExtentReports reports;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(String a) 
	{
		reports = new ExtentReports("ExtentReports.html", true);
		test = reports.startTest("AddNewAddress");
		
		driver = BaseClass1.getChromeDriver(a);
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		lp = new LoginPage1(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage1(driver);
	}
	
	@Test
	public void verifyUserCanLogin() throws InterruptedException, IOException
	{
	lp.enterEmailid();
	lp.enterPassword();
	lp.clickSubmit();
	hp.hovertoProfileName();
//	hp.waitToLoadPage();
	//hp.hovertoProfileName();
	String txt =hp.getLogOutTxt();
	
	Assert.assertEquals(txt, "Logout");
	
	test.log(LogStatus.PASS, "log In Test Passed");
	
	System.out.println("Verification Passed");
//	if (txt.equals("Logout"))
//	{
//		System.out.println("Test Passed");
//	}
//	else
//	{
//		Assert.fail();
//		//System.out.println("Test Failed");
//	}
	//hp.movePointer();
	
	}
	
	@DataProvider(name="dataSet")
	public String[][] dataToTest()
	{
		String[][] data = {{"Ganesh","9845124785","411041","Nanded City"},{"Atul","9845224785","411031","Nanded City"}};
		return data;
	
	}
	
	@Test(priority=1,  dataProvider="dataSet")
	public void verifyCanAddNewAddrress(String name,String mobNumber,String pinCode,String locality) throws EncryptedDocumentException, IOException, InterruptedException
	{
		hp.hovertoProfileName();
		hp.clickonMyProfileTxt();
		
		pp.ClickOnManageAddress();
		pp.ClickOnAddNewAddress();
		
		int oldCount = pp.getAddressCount();
		
		List<String> dataList = new ArrayList<String>();
		dataList.add(name);
		dataList.add(mobNumber);
		dataList.add(pinCode);
		dataList.add(locality);
		
		pp.getDataForAddress(dataList);
		
		pp.enterAdderessLine1();
		
		pp.clickSaveButton();
		Thread.sleep(3000);
		
		int newCount = pp.getAddressCount();
		Thread.sleep(3000);
		
		Assert.assertEquals(newCount, oldCount+1);
		
		test.log(LogStatus.PASS, "Added new Address");
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(pp.screenCapture(driver)),"taken ScreenShot");
		}
	}
	
	@AfterClass
	public void afterclass()
	{
		reports.endTest(test);
		reports.flush();
		
		//driver.quit();
	}


}
