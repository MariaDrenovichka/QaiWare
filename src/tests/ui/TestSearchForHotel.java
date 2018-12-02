package tests.ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.SearchForHotel;
import core.Browser;

public class TestSearchForHotel {


	private String expectedName = "Sofia";
	private String checkInDate = "11.11.2019";
	private String checkOutDate = "12.11.2019";
	private String filterSearchLocator = "//*[@class='go-right ellipsisFIX go-text-right mob-fs14']";
	private String dateInThePast = "11.11.2011";

	@Before
	public void setUp() {
		Browser.start();
	}

	@Test
	public void searchHotelsByDestinationWithCorrectData() {
		SearchForHotel.navigateToHotelsPage();
		SearchForHotel.searchHotelName(this.expectedName);
		SearchForHotel.checkInDate(checkInDate);
		SearchForHotel.checkOutDate(checkOutDate);
		SearchForHotel.submitSeachCriteria();
		String name = Browser.driver.findElement(By.xpath(filterSearchLocator)).getText();
		Assert.assertEquals(this.expectedName, name);
	}

	@Test
	public void searhHotelsByDestinationWithInCorrectData() {
		SearchForHotel.navigateToHotelsPage();
		SearchForHotel.searchHotelName(expectedName);
		SearchForHotel.checkInDate(checkInDate);
		SearchForHotel.checkOutDate(dateInThePast);
		SearchForHotel.submitSeachCriteria();
		WebElement checkThisElement = Browser.driver.findElement(By.xpath("//*[@class='icon_set_1_icon-95']"));
		Assert.assertEquals(false, checkThisElement.isDisplayed());
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}