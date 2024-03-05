package TestCases;


import org.testng.annotations.Test;
import PageObjects.Home_Page;
import TestBase.zighome;

public class navigate_to_upcoming_Bikes extends zighome {
	static Home_Page h_page;
	
	@Test(priority = 1)
	public void navigate() throws InterruptedException {
		logger.info("Open the zigwheel Homepage");
		h_page=new Home_Page(driver);
		h_page.New_Upcoming_Bikes();
	}
	
	@Test(priority = 2)
	public void Slect_Honda_Manuf() {
		logger.info("Select Honda as manufacturer");
		h_page.Manfu_Drop();
	}
	
	@Test(priority = 3)
	public void bike_under_4lakh() throws Exception {
		logger.info("Select Price under 4 lakh");
		h_page.viewMoreBikes();
		h_page.bikeModels();
		
	}
}
