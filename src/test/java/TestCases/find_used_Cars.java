package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.used_Cars;
import TestBase.zighome;

public class find_used_Cars extends zighome {
	static used_Cars uc;
	
	@Test(priority = 4)
	public void navigate_used_cars() throws InterruptedException {
		logger.info("Select used cars in chennai");
		uc=new used_Cars(driver);
		uc.used();
	}
	@Test(priority = 5)
	public void popular_model() throws InterruptedException, IOException {
		logger.info("Get model list");
		uc=new used_Cars(driver);
		uc.modelList();
		
	}
}
