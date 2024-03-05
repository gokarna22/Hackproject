package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.zighome;
import Utilities.excelout;

public class Home_Page  extends BasePage{
		
	public Home_Page(WebDriver driver) {
		super(driver);
	}
	
	//Navigating to Upcoming bikes section
	@FindBy(xpath="//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/a")
	WebElement New_Bikes;
	@FindBy(xpath="//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement Upcoming_Bikes;
	public String New_Upcoming_Bikes() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement bike=wait.until(ExpectedConditions.visibilityOf(New_Bikes));
		Actions action = new Actions(driver);            
		action.moveToElement(bike).perform();
		Thread.sleep(3000);
		zighome.screenshot("upcoming_bikes");
		action.moveToElement(Upcoming_Bikes).click().perform();
		String title=driver.getTitle();
		return title;
	}
	
	
	//Selecting Honda in upcoming bike 
	
	@FindBy(xpath="//*[@id='makeId']")
	WebElement drop;
	public void Manfu_Drop() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement menu=wait.until(ExpectedConditions.visibilityOf(drop));
		menu.click();
		zighome.screenshot("menu");
		Select select =new Select(menu);
		select.selectByVisibleText("Honda");
		zighome.screenshot("honda manfu");
	}
	
	@FindBy(xpath = "//*[@id=\"modelList\"]/li//span[contains(text(),'View More Bikes')]")
	WebElement viewMore;
	
	public void viewMoreBikes() throws Exception {
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", viewMore);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// Get bike models, prices, and expected launch date
	
	
	@FindBy(xpath="//strong[@class='lnk-hvr block of-hid h-height']")     //LIST OF HONDA BIKES
	List <WebElement> Honda_bike_names_list;
	@FindBy(xpath="//div[contains(@title,'Ex-Showroom Price')] ")   //COST OF THE BIKES
	List <WebElement> cost_of_bikes;
	@FindBy(xpath="//div[contains(text(),'Launch Date')][@class='clr-try fnt-14']")
	List <WebElement> launch_dates;
	
	public void bikeModels() throws Exception {
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> dateList = new ArrayList<String>();
		ArrayList<String> priceList = new ArrayList<String>();
		excelout.setCellData( "UpComingBikes", 0, 1, "Bike name");
		excelout.setCellData( "UpComingBikes", 0, 5, "Price");
		excelout.setCellData( "UpComingBikes", 0, 8, "Launch Date");
		int a=0;
		for(int i=0; i< cost_of_bikes.size(); i++)
		{
			String [] cost = cost_of_bikes.get(i).getText().split(" ");
			if(Double.parseDouble(cost[1].replace(",", "."))<=4.0) 
			{
				a++;
				nameList.add(Honda_bike_names_list.get(i).getText());
				dateList.add(cost_of_bikes.get(i).getText());
				try {
					priceList.add(launch_dates.get(i).getText());
				}
				catch (IndexOutOfBoundsException e) {
				}
			}
			if(cost[1].contains(","))
			{
				if(Integer.parseInt(cost[1].replace(",", ""))<400000)
				{
					
					nameList.add(Honda_bike_names_list.get(i).getText());
					dateList.add(cost_of_bikes.get(i).getText());
					try {
						priceList.add(launch_dates.get(i).getText());
					}
					catch (Exception e) {
					}
				}
			}	
		}
		System.out.println(a+"\n\n");
		for(int i=0;i<=a;i++) {
			System.out.println(nameList.get(i));
			excelout.setCellData( "UpComingBikes", i+1, 1, nameList.get(i));
			System.out.println(dateList.get(i));
			excelout.setCellData( "UpComingBikes", i+1, 5, dateList.get(i));
			//System.out.println(priceList.get(i));
			try {
				excelout.setCellData( "UpComingBikes", i+1, 8, priceList.get(i));
			}catch (Exception e) {
			}
		}
		WebElement new_bikes=driver.findElement(By.xpath("//*[@id='rhsDiv']/aside/div[4]/h2"));
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView();",new_bikes);
		zighome.screenshot("new_bikes");

		}
}
