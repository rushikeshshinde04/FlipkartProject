package pomClasses;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Utility1;



public class ProfilePage1 extends Utility1 {
	
	WebDriver driver;
	//div[text()='Manage Addresses']
	@FindBy(xpath="//div[text()='Manage Addresses']/parent::a")
	private WebElement manageAddress;

	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	private WebElement addNewAddressTxt;

	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement addressLine1;

	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveAddressButon;

	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List <WebElement> addressCount;



	public ProfilePage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void ClickOnManageAddress()
	{
		isElementVisible(driver, manageAddress);
		manageAddress.click();
	}

	public void ClickOnAddNewAddress()
	{
		isElementVisible(driver, addNewAddressTxt);
		addNewAddressTxt.click();
	}
	//public void getDataForAddress() throws EncryptedDocumentException, IOException

	public void getDataForAddress(List<String> a) throws EncryptedDocumentException, IOException
	{
		//List<String> list = getMultipleDataFromExcel(0 , 3);
		for(int i =1; i<=4; i++)
		{
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			//element.sendKeys(list.get(i-1));
			element.sendKeys(a.get(i-1));
		}
	}


	public int getAddressCount()
	{
		return addressCount.size();
	}

	public void enterAdderessLine1()
	{
		addressLine1.sendKeys("Dwaraka Nagari");
	}

	public void clickSaveButton()
	{
		saveAddressButon.click();
	}
	



}
