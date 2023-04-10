package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns 
{

	WebDriver driver;
	@FindBy (xpath="//button[text()='Post Campaign']") private WebElement post_campaign_button;
	@FindBy (xpath="//button[@class='L0Z3Pu']") private WebElement inbox;
	
	

	public Campaigns(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPost_campaign_button() throws InterruptedException
	{
		Thread.sleep(1000);
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//		j.executeScript("arguments[0].click();", post_campaign_button);
		post_campaign_button.click();
	}
	
	
}
