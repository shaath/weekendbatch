package com.orgHRM.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datap 
{
	
	@Test(dataProvider="data")
	public void bLaunch(String b,String u)
	{
		WebDriver driver = null;
		System.out.println(b+"----"+u);
		
		
		if (b.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.get(u);
			
		}
		else if (b.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\Cdownloads\\chromedriver.exe");
			driver=new ChromeDriver();
			
			driver.get(u);
			
		}
		else if (b.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver","F:\\Cdownloads\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.get(u);
		}
		
	}
	
	
	
	@DataProvider(parallel=true)
	public Object[][] data()
	{
		Object[][] d=new Object[3][2];
		
		d[0][0]="firefox";
		d[0][1]="http://google.com";
		
		d[1][0]="chrome";
		d[1][1]="http://gmail.com";
		
		d[2][0]="ie";
		d[2][1]="http://facebook.com";
		
		return d;
	}

}
