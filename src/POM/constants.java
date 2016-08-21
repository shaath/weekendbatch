package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class constants 
{
	WebDriver driver=new FirefoxDriver();
	
	loginPage lp=PageFactory.initElements(driver, loginPage.class);
	adminPage ap=PageFactory.initElements(driver, adminPage.class);
}
