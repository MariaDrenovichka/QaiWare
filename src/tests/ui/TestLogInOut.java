package tests.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Browser;
import core.LogInOut;
import core.BaseMethods;

public class TestLogInOut {
	public String validUserName = "user";
	public String validPass = "pass";
	private String invalidEmail = "invalid@email.com";
	private String invalidPass = "credentials";
	// private String partialEmail = "user";
	private String errorMessage = "//*[contains(text(), 'Invalid Email or Password')]";

	@Before
	public void setUp() {
		Browser.start();
	}

	@Test
	public void successfulLogin() {
		LogInOut.goTo();
		LogInOut.login(validUserName, validPass);
		BaseMethods.waitExplicit();
		Assert.assertEquals("My Account", Browser.driver.getTitle());
	}

	@Test
	public void unsuccesfullLogin() {
		LogInOut.goTo();
		LogInOut.login(invalidEmail, invalidPass);
		Assert.assertEquals("Invalid Email or Password", Browser.driver.findElement(By.xpath(errorMessage)).getText());
	}

	@Test
	public void successfulLogout() {
		LogInOut.goTo();
		LogInOut.login(validUserName, validPass);
		LogInOut.logout();
		Assert.assertEquals("Login", Browser.driver.getTitle());
	}

	@Test
	public void rememberCheckboxNotCheckedByDefauld() {
		LogInOut.goTo();
		BaseMethods.navigateToLogin();
//		Browser.waitForMe();
		WebElement checkBox = Browser.driver.findElement(By.id("remember-me"));
		Assert.assertFalse(checkBox.isSelected());
	}

	@Test
	public void rememberCredentialsCanBeChecked() {
		LogInOut.goTo();
		LogInOut.login(invalidEmail, invalidPass);
		LogInOut.checkRememberBox();
		WebElement rememberMeCheckBox = Browser.driver.findElement(By.id("remember-me"));
		Assert.assertTrue(rememberMeCheckBox.isSelected());
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}
