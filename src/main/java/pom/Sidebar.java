package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar 
{
	 WebDriver driver;
	@FindBy (xpath="//h5[text()='Campaigns']") private WebElement campaigns;
	@FindBy (xpath="//button[text()='Inbox']") private WebElement inbox;
	@FindBy (xpath="//h5[text()='Discovery']") private WebElement discovery;
	@FindBy (xpath="//h5[text()='Reporting']") private WebElement reporting;
	@FindBy (xpath="//h5[text()='Payments']") private WebElement payments;
	@FindBy (xpath="//h5[text()='Settings']") private WebElement settings;
	@FindBy (xpath="//h5[text()='Notifications']") private WebElement notifications;
	@FindBy (xpath="//img[@class='h-6 w-6 rounded-full']") private WebElement userProfile;
	@FindBy (xpath="//h5[text()='Logout']") private WebElement logout;
	@FindBy (xpath="//button[text()='Logout']") private WebElement confirmLogout;
	

	

	public Sidebar(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCampaigns()
	{
		campaigns.click();
	}
	
	public void clickOnLogout() throws InterruptedException
	{
		 Actions act= new Actions(driver);
		    act.moveToElement(userProfile).perform();
		    Thread.sleep(2000);
			act.click(logout).perform();
//		    logout.click();
	}
	public void clickOnConfirmLogout()
	{
		confirmLogout.click();
	}
	

}
