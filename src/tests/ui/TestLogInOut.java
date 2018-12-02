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
	private final String validEmail = "user";
	private final String validPass = "pass";
	private final String invalidEmail = "invalid@email.com";
	private final String invalidPass = "credentials";
	private final String errorMessageXpath = "//*[contains(text(), 'Invalid Email or Password')]";

	@Before
	public void setUp() {
		Browser.start();
	}

	@Test
	public void successfulLogin() {
		LogInOut.goTo();
		LogInOut.login(validEmail, validPass);
		BaseMethods.waitExplicit();
		Assert.assertEquals("My Account", Browser.driver.getTitle());
	}

	@Test
	public void unsuccesfullLogin() {
		LogInOut.goTo();
		LogInOut.login(invalidEmail, invalidPass);
		Assert.assertEquals("Invalid Email or Password", Browser.driver.findElement(By.xpath(errorMessageXpath)).getText());
	}

	@Test
	public void successfulLogout() {
		LogInOut.goTo();
		LogInOut.login(validEmail, validPass);
		LogInOut.logout();
		Assert.assertEquals("Login", Browser.driver.getTitle());
	}

	@Test
	public void rememberCheckboxNotCheckedByDefauld() {
		LogInOut.goTo();
		BaseMethods.navigateToLogin();
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
