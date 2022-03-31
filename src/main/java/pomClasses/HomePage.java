package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Utility1;


public class HomePage  extends Utility1 {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='_28p97w']")
	private WebElement ProfileName;
	
	@FindBy(xpath="//div[text()='My Profile']/parent::a/parent::li")
	private WebElement myProfileText;
	
	@FindBy(xpath="(//li[@class='_2NOVgj'])[10]")  //OR //(////div[text()='Logout']
	private WebElement LogOutText;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void hovertoProfileName()
	{
		isElementVisible(driver, ProfileName);
		moveToElement(driver, ProfileName);
	}
	
	public void clickonMyProfileTxt()
	{
		isElementVisible(driver, myProfileText);
		myProfileText.click();
	}
	
	public String getLogOutTxt()
	{
		return LogOutText.getText();
	}
	
//	public void waitToLoadPage()
//	{
//	expliciteWait(driver, LogOutText);
//	}
//	
	public void movePointer() throws InterruptedException
	{
	moveByOffset(driver);
	Thread.sleep(2000);
	}

}
