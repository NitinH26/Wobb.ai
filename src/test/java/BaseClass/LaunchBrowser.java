package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowser 
{
	public WebDriver driver;
	public WebDriver openChrome()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/ChromeDriver/chromedriver.exe");
		
		 driver= new ChromeDriver();
		
		return driver;
		
	}
	
//	public WebDriver openEdge()
//	{
//		System.setProperty("webdriver.edge.driver",".\\ASSIG\\Drivers\\EdgeDriver\\msedgedriver.exe");
//		
//		 driver= new EdgeDriver();
//		
//		return driver;
//		
//	}

}
