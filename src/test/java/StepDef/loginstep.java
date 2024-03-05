package StepDef;

import org.openqa.selenium.WebDriver;
import PageObjects.login;
import TestBase.zighome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstep {
	public static WebDriver driver;
	zighome zig=new zighome(); 
	public static login log;
	@Given("go on zigwheels site")
	public void be_on_zigwheels_site() {
	   driver=zig.driverSetup();
	   log=new login(driver);
	   System.out.println("present on site");
	}
	@When("clcik on login")
	public void clcik_on_login_sign() {
	   System.out.println(" ");
	}

	@When("click on google sign-in")
	public void click_on_google_sign_in() {
		System.out.println(" ");
	}

	@Then("enter wrong mail-id and error appear")
	public void enter_wrong_mail_id_and_error_appear() throws InterruptedException {
	    log.signup();
	    driver.quit();
	}
}
