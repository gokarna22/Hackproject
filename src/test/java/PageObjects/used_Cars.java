package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.zighome;
import Utilities.excelout;


public class used_Cars extends BasePage{
	public used_Cars(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a")
	WebElement usedcars;
	@FindBy(xpath="//*[@id='headerNewNavWrap']/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement findusedcar;
	public void used() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement oldcars=wait.until(ExpectedConditions.visibilityOf(usedcars));
		Actions action = new Actions(driver);            
		action.moveToElement(oldcars).perform();
		Thread.sleep(3000);
		zighome.screenshot("used_Cars_menu");
		action.moveToElement(findusedcar).click().perform();
	}
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	List<WebElement> modelName;
	public void modelList() throws InterruptedException, IOException {
		 
		// Scroll down to make all elements visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("scroll(0, 500)");
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(modelName));
		zighome.screenshot("popular_models");
		excelout.setCellData( "Used_Cars", 0, 1, "Car Model and Make");
	    
	    // Display the list of popular models on the console
	    System.out.println("Following is the list of Popular models:");
		for (int i = 0; i < modelName.size(); i++) {
			System.out.println(modelName.get(i).getText());
			excelout.setCellData( "Used_Cars", i+1, 1, modelName.get(i).getText());
		}
	}

}
