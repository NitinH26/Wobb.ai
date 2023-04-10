package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{    WebDriver driver;
	@FindBy (xpath="//*[@id=\"root\"]/div[1]/div/div/div/div/div/form/div[1]/div/div[1]/div[1]/input") private WebElement userName;
	@FindBy (xpath="//button[text()='Next']") private WebElement nextButton;
	@FindBy (xpath="//input[@type='password']") private WebElement password;
	@FindBy (xpath="//button[@class='_btnSubmit_g7h1l_28']") private WebElement signin;

	
	public LoginPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String a)
	{	userName.click();
		userName.sendKeys(a);
	}

	public void clickOnNextButton()
	{
		nextButton.click();
	}
	
	public void enterPassword(String b)
	{
		password.sendKeys(b);
	}
	
	public void clickOnSignin()
	{
		signin.click();
	}
	
	
}
