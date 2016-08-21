package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class loginTC extends constants
{
	@Test
	public void login()
	{
		
		driver.get(lp.url);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		lp.org_Login(lp.u, lp.p);
		ap.welcomeclick();
		ap.logoutclick();
		
		driver.close();
		
		
	}

}
