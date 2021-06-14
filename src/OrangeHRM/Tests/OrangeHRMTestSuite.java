package OrangeHRM.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import OrangeHRM.Library.Employee;
import OrangeHRM.Library.Login;
import OrangeHRM.Library.Users;
import Utils.Apputils;
import Utils.XLutils;

public class OrangeHRMTestSuite extends Apputils
{

	public String keywordfile="C:\\Users\\Phani\\workspace21\\OrangeHRM_HybridFrame\\Keywordfile\\Hybirdxl.xlsx";
	public String tcsheet="Testcases";
	public String tssheet="Teststeps";
	

	@Test
	public void batchTest() throws IOException, InterruptedException
	{
		int tccount,tscount;
		String tcid,tstcid,tcexeflag,keyword,tsres,tcres;
		String adminuid,adminpwd,fname,lname,empname,empuid,emppwd;
		boolean res=false;
		
		tccount=XLutils.getRowCount(keywordfile, tcsheet);
		tscount=XLutils.getRowCount(keywordfile, tssheet);
		
        Login l=new Login();
        Employee emp=new Employee();
        Users u=new Users();
		
		for (int i = 1; i <=tccount; i++) 
		{
			tcid=XLutils.getStringCellData(keywordfile, tcsheet, i, 0);
			tcexeflag=XLutils.getStringCellData(keywordfile, tcsheet, i, 2);
			if (tcexeflag.equalsIgnoreCase("y")) 
			{
				for (int j = 1; j<=tscount; j++) 
				{
					tstcid=XLutils.getStringCellData(keywordfile, tssheet, j, 0);
					if (tstcid.equalsIgnoreCase(tcid)) 
					{
						keyword=XLutils.getStringCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
						adminuid=XLutils.getStringCellData(keywordfile, tssheet, j, 5);
						adminpwd=XLutils.getStringCellData(keywordfile, tssheet, j, 6);
						res=l.Adminlogin(adminuid, adminpwd);
							break;

						case "adminlogout":
							res=l.logout();
							break;
							
						case "newempreg":
							fname=XLutils.getStringCellData(keywordfile, tssheet, j, 5);
							lname=XLutils.getStringCellData(keywordfile, tssheet, j, 6);
							res=emp.addemployee(fname, lname);
							break;
						case "newuserreg":
							empname=XLutils.getStringCellData(keywordfile, tssheet, j, 5);
							empuid=XLutils.getStringCellData(keywordfile, tssheet, j, 6);
							emppwd=XLutils.getStringCellData(keywordfile, tssheet, j, 7);
							res=u.addUser(empname, empuid, emppwd);
							break;
						case "emplogin":
							empuid=XLutils.getStringCellData(keywordfile, tssheet, j, 5);
							emppwd=XLutils.getStringCellData(keywordfile, tssheet, j, 6);
							res=l.emplogin(empuid, emppwd);
							break;
						case "emplogout":
							res=l.logout();
							break;
						}
						if (res) 
						{
							tsres="Pass";
									XLutils.setCelldata(keywordfile, tssheet, j, 3, tsres);
									XLutils.fillGreenColor(keywordfile, tssheet, j, 3);
						}else
						{
							tsres="Fail";
							XLutils.setCelldata(keywordfile, tssheet, j, 3, tsres);
                            XLutils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						tcres=XLutils.getStringCellData(keywordfile, tcsheet, i, 3);
						if (!tcres.equalsIgnoreCase("fail")) 
						{
							XLutils.setCelldata(keywordfile, tcsheet, i, 3, tsres);
						}
						tcres=XLutils.getStringCellData(keywordfile, tcsheet, i, 3);
						if (tcres.equalsIgnoreCase("Pass")) 
						{
							XLutils.fillGreenColor(keywordfile, tcsheet, i, 3);
						}else
						{
							XLutils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
					}		
				}
			}else
			{
				XLutils.setCelldata(keywordfile, tcsheet, i, 3, "Blocked");
				XLutils.fillRedColor(keywordfile, tcsheet, i, 3);
			}
		}
	}
	
}
