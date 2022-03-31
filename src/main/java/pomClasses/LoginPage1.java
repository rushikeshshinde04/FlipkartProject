package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Utility1;

public class LoginPage1 extends Utility1 {

	WebDriver driver;
	
	@FindBy (xpath="(//input[@type='text'])[2]")
	private WebElement emailid;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy (xpath="(//button[@type='submit'])[2]")
	private WebElement submitbutton;
	
//	@FindBy (xpath="//div[@class='_28p97w']")
//	private WebElement profileName;
	
	public LoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void enterEmailid() throws IOException
	{
		//emailid.sendKeys("9420019067");
		
		emailid.sendKeys(getConfigData("email"));
	}
	public void enterPassword() throws IOException
	{
		//pass.sendKeys("Rushi@6277");
		pass.sendKeys(getConfigData("password"));

	}
	public void clickSubmit() throws InterruptedException
	{
		submitbutton.click();
		Thread.sleep(2000);
	}

}
