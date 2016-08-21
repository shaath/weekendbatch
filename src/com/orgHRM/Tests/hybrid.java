package com.orgHRM.Tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.orgHRM.Master.orgMaster;

public class hybrid 
{
	@Test
	public void driverscript() throws IOException
	{
		String res = null;
		orgMaster om=new orgMaster();
		String xlpath="F:\\morning630AM\\weekend\\src\\com\\orgHRM\\Testdata\\Hybrid.xlsx";
		String xlout="F:\\morning630AM\\weekend\\src\\com\\orgHRM\\Results\\Hybridres.xlsx";
		FileInputStream fi=new FileInputStream(xlpath);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Testcase");
		XSSFSheet ws1=wb.getSheet("Teststeps");
		XSSFSheet ws2=wb.getSheet("empreg");
		
		int tcRc=ws.getLastRowNum();
		int tsRc=ws1.getLastRowNum();
		int empRc=ws2.getLastRowNum();
		
		for (int i = 1; i <= tcRc; i++) 
		{
			ws.getRow(i).createCell(3);
			String exec=ws.getRow(i).getCell(2).getStringCellValue();
			if (exec.equalsIgnoreCase("y"))
			{
				String tcId=ws.getRow(i).getCell(0).getStringCellValue();
				
				for (int j = 1; j <= tsRc; j++) 
				{
					
					String tstcId=ws1.getRow(j).getCell(0).getStringCellValue();
					if (tcId.equalsIgnoreCase(tstcId))
					{
						String key=ws1.getRow(j).getCell(3).getStringCellValue();
						System.out.println(key);
						switch (key) 
						{
						case "Launch":
							res=om.org_Launch("http://orangehrm.qedgetech.com");
							break;
						case "login":	
							res=om.org_Login("Admin", "admin");
							break;
						case "logout":	
							res=om.org_Logout();
							om.org_Close();
							break;
						case "Empreg":	
							for (int k = 1; k <= empRc; k++)
							{
								String f=ws2.getRow(k).getCell(0).getStringCellValue();
								String l=ws2.getRow(k).getCell(1).getStringCellValue();
								res=om.org_Empreg(f, l);
								ws2.getRow(k).createCell(2).setCellValue(res);
							}
							
							break;
						case "Userreg":	
							res=om.org_Userreg("Srinu P", "Srinu123123", "Srinu123123", "Srinu123123");
							break;
						case "Ulogin":	
							res=om.org_Login("Narendera123123", "Narendera123123");
							break;
						default:
							System.out.println("Select a proper keyword");
							break;
						}
						ws1.getRow(j).createCell(4).setCellValue(res);
						String status=ws.getRow(i).getCell(3).getStringCellValue();
						if (!status.equalsIgnoreCase("FAIL"))
						{
							
							ws.getRow(i).getCell(3).setCellValue(res);
							
						}
						else
						{
							ws.getRow(i).getCell(3).setCellValue("Fail");
						}
						
					}
					
				}
				
			}
			else
			{
				ws.getRow(i).createCell(3).setCellValue("BLOCKED");
			}
			
		}
		FileOutputStream fo=new FileOutputStream(xlout);
		wb.write(fo);
		wb.close();
	}


}
