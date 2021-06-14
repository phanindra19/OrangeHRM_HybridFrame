package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Apputils 
{

	public static WebDriver driver;
	public static String url="http://orangehrm.qedgetech.com";
	
	@BeforeTest
	public static void lanuchapp() 
	{
	driver=new FirefoxDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
		
	}
	
	@AfterTest
	public static void closeapp() 
	{
		driver.close();
	}
}
