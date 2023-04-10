package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Post_Campaign 
{
	WebDriver driver;
	Actions act;
	@FindBy (xpath="//input[@id='campaign-name']") private WebElement campaignName;
	@FindBy (xpath="//input[@name='Platform']") private WebElement platform;
	//@FindBy (xpath="//div[@aria-haspopup='listbox']") private WebElement platform;
	//@FindBy (xpath="(//button//span[@class='MuiTouchRipple-root'])[2]") private WebElement deliverables;

	@FindBy (xpath="//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/p") private WebElement deliverables;
	@FindBy (xpath="//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[4]/div/div/div/div") private WebElement categories;
	@FindBy (xpath="//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[5]/div/div/div[1]/div") private WebElement followerRange;
//	@FindBy (xpath="//input[@type='number']") private WebElement followerRange;

	@FindBy (xpath="//input[@id='influencer-required']") private WebElement influencerRequired;
	@FindBy (xpath="//button[text()='Save']") private WebElement saveButton;
	@FindBy (xpath="//button[text()='Cancel']") private WebElement cancel;
	@FindBy (xpath="(//p[@class='MuiTypography-root MuiTypography-body1'])[2]") private WebElement campaignRequirement;
	@FindBy (xpath="(//p[@class='MuiTypography-root MuiTypography-body1'])[3]") private WebElement influencerPayoutAndMilestones;
	@FindBy (xpath="//li[@data-value='YOUTUBE']") private WebElement selectYoutube;
//	@FindBy (xpath="//button//span[@class='MuiTouchRipple-root'])[6]") private WebElement addDeliverablesdedicatedVideo;
	@FindBy (xpath="/html/body/div[5]/div[3]/div/ul/div[1]/div[1]/div/button[2]/span[1]") private WebElement addDeliverablesdedicatedVideo;

	@FindBy (xpath="(//input[@type='checkbox'])[2]") private WebElement addCategoriesComedy;
	@FindBy (xpath="(//input[@type='checkbox'])[2]") private WebElement addfFollowerRange;
	
	
	public Post_Campaign(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public String clickOnCampaignName()
	{
		String msg=campaignName.getText();
		return msg;	
	}
	public void enterCampaignName(String a)
	{   campaignName.click();
		campaignName.sendKeys(a);
	}
	
	public String clickOnPlatform()
	{
		String msg=platform.getText();
		return msg;	
	}
	public void SelectPlatform() throws InterruptedException
	{	
		//platform.click();
	    act= new Actions(driver);
		act.click(platform).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ARROW_UP).perform();
		act.click(platform).perform();
//		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
//		act.moveToElement(selectYoutube).perform();
//		act.click(selectYoutube).perform();
		
	}
	public String clickOnDeliverables()
	{
		String msg=deliverables.getText();
		return msg;	
	}
	public void SelectDeliverables() throws InterruptedException
	{	
//		deliverables.click();
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", deliverables);
		j.executeScript("arguments[0].click();", addDeliverablesdedicatedVideo);
		 act = new Actions(driver);
         act.moveByOffset(0, 0).click().build().perform();	
//		addDeliverablesdedicatedVideo.click();
		
//	    act= new Actions(driver);
//	    act.moveToElement(addDeliverablesdedicatedVideo).perform();
//		act.click(addDeliverablesdedicatedVideo).perform();
		//Thread.sleep(2000);
//		act.click(addDeliverablesdedicatedVideo).perform();		
//		act.sendKeys(Keys.ARROW_DOWN).perform();
//		act.sendKeys(Keys.ARROW_UP).perform();
//		act.sendKeys(Keys.ENTER).perform();
    	Thread.sleep(1000);
	}
	
	public String clickOnCategories()
	{
		String msg=categories.getText();
		return msg;	
	}
	
	public void SelectCategories() throws InterruptedException
	{	
		categories.click();
    	Thread.sleep(1000);
    	addCategoriesComedy.click();
    	Thread.sleep(1000);
    	 act = new Actions(driver);
          act.moveByOffset(0, 0).click().build().perform();
    	//categories.click();
	}
	
	public void SelectFollowerRange() throws InterruptedException
	{	
		followerRange.click();
    	addfFollowerRange.click();
    	 act = new Actions(driver);
         act.moveByOffset(0, 0).click().build().perform();	
	}
	
	public String clickOnInfluencerRequired()
	{
		String msg=influencerRequired.getText();
		return msg;	
	}
	
	public void addInfluencerRequired()
	{
		influencerRequired.sendKeys("15");
	}
	
	public void clickOnsaveButton()
	{
		saveButton.click();
	}
	

}
