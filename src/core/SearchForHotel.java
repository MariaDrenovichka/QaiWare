package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.LogInOut;
import core.Browser;
import org.openqa.selenium.interactions.Actions;
import core.BaseMethods;

public class SearchForHotel {
	
	public static String validUserName = "user@phptravels.com";
	public static String validPass = "demouser";
	private static String submitButton = "//*[@type='submit']";
	private static String searchResultMatches = "//*[@class='select2-result-sub']";
	private static String searchCriteria = "span.select2-chosen";


	public static void navigateToHotelsPage(){
	BaseMethods.goTo();
	LogInOut.login(validUserName, validPass);
	BaseMethods.waitExplicit();
	Browser.driver.findElement(By.xpath("//*[@class='hidden-xs']")).click();
	BaseMethods.waitForElement();
	}

	public static void searchHotelName(String name) {
		WebElement searchName = Browser.driver.findElement(By.cssSelector(searchCriteria));// .get(0);
		Actions actions = new Actions(Browser.driver);
		actions.moveToElement(searchName);
		actions.click();
		actions.sendKeys(name);
		actions.build().perform();
		BaseMethods.waitForElement();
		Browser.driver.findElement(By.xpath(searchResultMatches)).click();
	}

	public static void checkInDate(String checkInDate) {
		WebElement checkIn = Browser.driver.findElement(By.name("checkin"));
		Actions enterCheckInDate = new Actions(Browser.driver);
		enterCheckInDate.moveToElement(checkIn);
		enterCheckInDate.click();
		enterCheckInDate.sendKeys(checkInDate);
		enterCheckInDate.build().perform();
	}

	public static void checkOutDate(String checkOutDate) {
		WebElement checkOut = Browser.driver.findElement(By.name("checkout"));
		Actions enterCheckOutDate = new Actions(Browser.driver);
		enterCheckOutDate.moveToElement(checkOut);
		enterCheckOutDate.click();
		enterCheckOutDate.sendKeys(checkOutDate);
		enterCheckOutDate.build().perform();
	}

	public static void submitSeachCriteria() {
		Browser.driver.findElement(By.xpath(submitButton)).click();
	}
}
