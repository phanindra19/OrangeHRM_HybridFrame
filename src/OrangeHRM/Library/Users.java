package OrangeHRM.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Apputils;

public class Users extends Apputils
{

	/*public boolean adduser(String empname,String uname,String pword) throws InterruptedException
	{
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("systemUser_password")).sendKeys(pword);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pword);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("serchSystemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("searchBtn")).click();
		
		
		String expval,actval;
		expval=uname;
		boolean userexist=false;
		WebElement emptable;
		emptable=driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows,cols;
		rows=emptable.findElements(By.tagName("tr"));
		
		for (int i=1; i <rows.size(); i++) 
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			actval=cols.get(1).getText();
			
			if (expval.equals(actval)) 
			{
				userexist=true;
				break;
			}
			if (userexist) 
			{
			return true;	
			}else
			{
				return false;
			}
			
		}	
	}*/
	
	
	public boolean addUser(String empname,String uname,String pword) throws InterruptedException
	{
		
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
		driver.findElement(By.id("systemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("systemUser_password")).sendKeys(pword);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pword);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(uname);
		driver.findElement(By.id("searchBtn")).click();
		
		
		String expval,actval;
		expval=uname;
		boolean userexist=false;
		WebElement emptable;		
		emptable=driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows,cols;
		rows=emptable.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size();i++)
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			actval=cols.get(1).getText();
			
			if(expval.equals(actval))
			{
				userexist=true;
				break;
			}
		}
		if(userexist)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	
	
}

	
	
	

