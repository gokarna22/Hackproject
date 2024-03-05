package StepDef;

import org.openqa.selenium.WebDriver;

import PageObjects.Home_Page;
import TestBase.zighome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Bikesstep {
	public static WebDriver driver;
	zighome zig=new zighome(); 
	public static Home_Page hp;
	@Given("Be on zigwheels site")
	public void be_on_zigwheels_site() {
	   driver=zig.driverSetup();
	   hp=new Home_Page(driver);
	   System.out.println("present on site");
	}

	@When("hover to new bikes and select upcoming bikes")
	public void hover_to_new_bikes_and_select_upcoming_bikes() throws InterruptedException {
		hp.New_Upcoming_Bikes();
	}

	@When("select manufacture as Honda drom Dropdwon")
	public void select_manufacture_as_honda_drom_dropdwon() {
	  hp.Manfu_Drop();
	}

	@Then("Get details of bikes under four lakh")
	public void get_details_of_bikes_under_four_lakh() throws Exception {
	   hp.viewMoreBikes();
	   hp.bikeModels();
	   driver.quit();
	}
}
