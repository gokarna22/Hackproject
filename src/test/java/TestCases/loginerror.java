package TestCases;

import org.testng.annotations.Test;

import PageObjects.login;
import TestBase.zighome;

public class loginerror extends zighome{
	static login use;
	
	@Test(priority = 6)
	public void user_reg() throws InterruptedException {
		logger.info("Login the site with google");
		use=new login(driver);
		use.signup();
		
	}

}
