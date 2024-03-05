package StepDef;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import PageObjects.used_Cars;
import TestBase.zighome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class usedchennaicars {
	public static WebDriver driver;
	zighome zig=new zighome(); 
	public static used_Cars uc;
	@Given("Go to zigwheels site")
	public void go_to_zigwheels_site() {
		driver=zig.driverSetup();
		   uc=new used_Cars(driver);
		   System.out.println("present on site");
	}

	@When("hover to used bikes and select chennai")
	public void hover_to_used_bikes_and_select_chennai() throws InterruptedException {
	    uc.used();
	}

	@Then("Get all popular models")
	public void get_all_popular_models() throws InterruptedException, IOException {
		uc.modelList();
		driver.quit();
	}

}
