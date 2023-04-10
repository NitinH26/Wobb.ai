package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseClass.LaunchBrowser;
import pom.Campaigns;
import pom.LoginPage;
import pom.MainPage;
import pom.Post_Campaign;
import pom.Sidebar;
import utils.UtilityClass;


public class TestClass1 extends LaunchBrowser
{	
	int TestId;
	SoftAssert soft;
	MainPage mainPage;
	LoginPage loginPage;
	Campaigns campaigns;
	Post_Campaign postCampaign;
	Sidebar sidebar;
	
	@BeforeTest 
	public void openBrowser()
	{
		openChrome();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void createPOMObject()
	{
		mainPage= new MainPage(driver);
		loginPage= new LoginPage(driver);
		campaigns= new Campaigns(driver);
		postCampaign= new Post_Campaign(driver);
		sidebar= new Sidebar(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws InterruptedException, IOException
	{
		driver.get("http://stage.wobb.ai"); // open website
		Thread.sleep(2000);
		mainPage.clickOnLoginButton();
		Thread.sleep(2000);

		loginPage.enterUserName(UtilityClass.fetchData("number"));
		loginPage.clickOnNextButton();
		Thread.sleep(1000);
		loginPage.enterPassword(UtilityClass.fetchData("password"));
		Thread.sleep(1000);
		loginPage.clickOnSignin();
	}
	
	@Test(priority=1)
	public void verifyHomePage() throws IOException, InterruptedException
	{
		TestId=101;
		
		Thread.sleep(2000);
		String actualUrl = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		
		String expectedlUrl = UtilityClass.fetchData("homePageURL");
		
		Assert.assertEquals(actualUrl,expectedlUrl);

	}
	
	@Test (priority=0)
	public void verifyUser() throws IOException
	{
		TestId=100;
		
		//String actualUserName= header.clickOnUser();
		//String expectedUserName= UtilityClass.fetchData("user");
		
		//SoftAssert soft= new SoftAssert();
		//soft.assertEquals(actualUserName, expectedUserName);
		System.out.println("There is no option available for verification ");	
	}
	
	@Test (priority=2)
	public void verifyErrorMessagesForFieldPrasentOnPostCampaign() throws IOException, InterruptedException
	{
		TestId=102;
	
		campaigns.clickOnPost_campaign_button();
		Thread.sleep(1000);
		postCampaign.clickOnSaveButton();// with all empty fields
		
		String actualCampaignNameErrorMsg = postCampaign.clickOnCampaignName();
		String actualPlatformErrorMsg = postCampaign.clickOnPlatform();
		String actualDeliverablesErrorMsg = postCampaign.clickOnDeliverables();
		String actualCategoriesErrorMsg = postCampaign.clickOnCategories();
		String actualInfluencerRequiredErrorMsg = postCampaign.clickOnInfluencerRequired();
		
		String expectedCampaignNameErrorMsg = UtilityClass.fetchData("expectedCampaignNameErrorMsg");
		String expectedPlatformErrorMsg = UtilityClass.fetchData("expectedPlatformErrorMsg");
		String expectedDeliverablesErrorMsg= UtilityClass.fetchData("expectedDeliverablesErrorMsg");
		String expectedCategoriesErrorMsg=UtilityClass.fetchData("expectedCategoriesErrorMsg");
		String expectedInfluencerRequiredErrorMsg=UtilityClass.fetchData("expectedInfluencerRequiredErrorMsg");

	    soft= new SoftAssert();
		soft.assertEquals(actualCampaignNameErrorMsg, expectedCampaignNameErrorMsg);
		soft.assertEquals(actualPlatformErrorMsg, expectedPlatformErrorMsg);
		soft.assertEquals(actualDeliverablesErrorMsg, expectedDeliverablesErrorMsg);
		soft.assertEquals(actualCategoriesErrorMsg, expectedCategoriesErrorMsg);
		soft.assertEquals(actualInfluencerRequiredErrorMsg, expectedInfluencerRequiredErrorMsg);
		
	}
	
	@Test(priority=3)
	public void saveInfluencerRequirementData() throws IOException, InterruptedException
	{
		TestId=103;
		campaigns.clickOnPost_campaign_button();
		Thread.sleep(1000);
		postCampaign.enterCampaignName(UtilityClass.fetchData("enterCampaignName"));
		postCampaign.SelectPlatform();
		Thread.sleep(1000);
		postCampaign.SelectDeliverables();
		Thread.sleep(1000);
		postCampaign.SelectCategories();
		Thread.sleep(1000);
		
		Thread.sleep(1000);

		postCampaign.SelectFollowerRange();
		postCampaign.addInfluencerRequired();
		postCampaign.clickOnsaveButton();
		Thread.sleep(1000);
	    
		String actualMsg="Need Save Verification Msg";
		String expectedMsg="Influencer Requirement Information Saved";
	    soft= new SoftAssert();
	    soft.assertEquals(actualMsg, expectedMsg);
	    soft.assertAll();
	    
	}
	
	
	
	@AfterMethod
	public void logoutToApplication(ITestResult result) throws IOException, InterruptedException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			UtilityClass.capturescreenshot(driver, TestId);
		}
		
		sidebar.clickOnLogout();
		sidebar.clickOnConfirmLogout();
		
	}
	
	@AfterClass
	public void clearPOMObject()
	{
//		mainPage= null;
//		loginPage= null;
//		loginPage=null;
//		campaigns=null;
//		postCampaign=null;
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	

}
