package OrangeHRM.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Apputils;

public class Employee extends Apputils
{

	public boolean addemployee(String fname,String lname) throws InterruptedException
	{
		String expval,actval;
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		expval=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.linkText("Employee List")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("empserch_employee_name_empName")).sendKeys(fname+"  "+lname);
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement emptable;
		emptable=driver.findElement(By.id("resultTable"));
		List<WebElement> rows,cols;
		rows=emptable.findElements(By.tagName("tr"));
		boolean empexist=false;
		for (int i=1; i<rows.size(); i++)
		{
			cols=rows.get(i).findElements(By.tagName("td"));
			actval=cols.get(1).getText();
			if (expval.equals(actval)) 
			{
				empexist=true;
				break;
			}
		}
		if (empexist) 
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
}
