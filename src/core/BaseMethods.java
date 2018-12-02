package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
	
	private static String loginIconSelector = "#li_myaccount > ul > li:nth-child(1) > a";
	

	public static void goTo() {
		Browser.driver.get("https://www.phptravels.net");
	}
	
	public static void clickHiddenElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) Browser.driver; 
		js.executeScript("arguments[0].click();", element);
	}
	
//	public static void waitForMe(){
//		Scanner sc = new Scanner(System.in);
//		int i = sc.nextInt();
//	}
		
	public static void navigateToLogin(){
	   	WebElement loginButton = Browser.driver.findElements(By.cssSelector(loginIconSelector)).get(0);
    	clickHiddenElement(loginButton);
	}
	
	public static void waitExplicit() {
		WebElement verifyElement = (new WebDriverWait(Browser.driver, 10))
				.until(ExpectedConditions.
						presenceOfElementLocated(By.className("bookings-icon"))); 
	}
	public static void waitForElement(){
		WebElement waitForElement = (new WebDriverWait(Browser.driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input']")));
	}
}
