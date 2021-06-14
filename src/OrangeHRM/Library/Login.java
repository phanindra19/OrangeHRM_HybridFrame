package OrangeHRM.Library;

import org.openqa.selenium.By;

import Utils.Apputils;

public class Login extends Apputils
{

	public boolean Adminlogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		if (driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public boolean emplogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		if (driver.findElement(By.linkText("Leave")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	public boolean logout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) 
		{
			return true;
		}else
		{
			return false;
		}
	}
}
