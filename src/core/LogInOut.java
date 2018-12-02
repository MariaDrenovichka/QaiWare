package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Browser;
import core.BaseMethods;

public class LogInOut {
	private static String logOutSelector = "//*[contains(text(), 'Logout')]";
	private static String loginBigButtonSelector = "button.btn.btn-action.btn-lg.btn-block.loginbtn";


	public static void login(String email, String password) {
		BaseMethods.navigateToLogin();
		Browser.driver.findElement(By.name("username")).sendKeys(email);
		Browser.driver.findElement(By.name("password")).sendKeys(password);
		Browser.driver.findElement(By.cssSelector(loginBigButtonSelector)).click();
//		Browser.waitForMe();
//		Browser.waitExplicit();
	}

	public static void checkRememberBox() {
		WebElement rememberMeCheckBox = Browser.driver.findElement(By.id("remember-me"));
		if (!rememberMeCheckBox.isSelected())
			;
		rememberMeCheckBox.click();
	}

	public static void logout() {
		WebElement logOutButton = Browser.driver.findElement(By.xpath(logOutSelector));
		BaseMethods.clickHiddenElement(logOutButton);
	}
}
