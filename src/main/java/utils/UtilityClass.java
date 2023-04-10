package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static String fetchData(String key) throws IOException
	{
		FileInputStream file= new FileInputStream("propertyFile");
		Properties p= new Properties();
		p.load(file);
		
	    String value= p.getProperty(key);
	    return value;
	    
	}
	
	public static void capturescreenshot(WebDriver driver, int TestId) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest= new File ("Sceenshots/"+ TestId + ".jpg");
		
		FileHandler.copy(src, dest);
	}

}
