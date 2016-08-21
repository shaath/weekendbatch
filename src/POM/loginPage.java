package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage 
{
	public static String url="http://orangehrm.qedgetech.com";
	public static String u="Admin",p="admin";
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement login;
	
	public void org_Login(String u, String p)
	{
		username.sendKeys(u);
		password.sendKeys(p);
		login.click();
	}
	
	

}
