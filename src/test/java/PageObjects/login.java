package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.zighome;

public class login extends BasePage {
	public login(WebDriver driver) {
		super(driver);
	}
	//Click the login button 
	@FindBy(xpath="//div[@id='forum_login_title_lg']")
	WebElement login_button;
	//Click on google button 
	@FindBy(xpath="//*[@id='myModal3-modal-content']/div[1]/div/div[3]/div[6]/div")
	WebElement google_login_button;
	//select the email
	@FindBy(xpath="//*[@id='identifierId']")
	WebElement email;
	//Click on next button 
	@FindBy(xpath="//*[@id='identifierNext']/div/button/span")
	WebElement next_Button;
	//Click close login 
	@FindBy(xpath="//*[@id='report_submit_close_login']")
	WebElement close_login;
	
	public void signup() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement loginuser=wait.until(ExpectedConditions.elementToBeClickable(login_button));
		loginuser.click();
		zighome.screenshot("login");
		WebElement sign=wait.until(ExpectedConditions.visibilityOf(google_login_button));
		Thread.sleep(3000);
		sign.click();
		zighome.screenshot("google");
		Thread.sleep(3000);
		Set<String> win=driver.getWindowHandles();
		List<String> winid= new ArrayList(win);
		driver.switchTo().window(winid.get(1));
		email.sendKeys("abc@xyz");
		zighome.screenshot("mail");
		next_Button.click();
		zighome.screenshot("error");
		Thread.sleep(2000);
	}
}
