package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage 
{

	  WebDriver driver;
		@FindBy (xpath="//a[@class='web-log-in']") private WebElement loginButton;
		
		
		public MainPage(WebDriver driver)
		{	
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnLoginButton()
		{
			loginButton.click();
		}

		
}