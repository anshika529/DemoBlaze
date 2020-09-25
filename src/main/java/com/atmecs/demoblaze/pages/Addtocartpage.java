package com.atmecs.demoblaze.pages;

import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.demoblaze.constants.Constants;
import com.atmecs.demoblaze.helpers.ElementHelpers;
import com.atmecs.demoblaze.testsuit.BaseTest;
import com.atmecs.demoblaze.utils.PropertyReader;

public class Addtocartpage extends BaseTest {
	Properties Loc_path;
	Properties Data_path;

	public void addtocartactions() throws InterruptedException {
		Loc_path = PropertyReader.readProperties(Constants.Locator_file);
		Data_path = PropertyReader.readProperties(Constants.TestData_file);

		ElementHelpers.clickElement(driver, Loc_path.getProperty("Home"));
		ElementHelpers.clickElement(driver, Loc_path.getProperty("MobileLink"));
		ElementHelpers.clickElement(driver, Loc_path.getProperty("Addtocart"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		ElementHelpers.clickElement(driver, Loc_path.getProperty("CartLink"));

		Thread.sleep(5000);
		ElementHelpers.clickElement(driver, Loc_path.getProperty("Placeorder"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("Name"), Data_path.getProperty("Name"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("Country"), Data_path.getProperty("Country"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("City"), Data_path.getProperty("City"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("Creditcard"), Data_path.getProperty("Creditcard"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("Month"), Data_path.getProperty("Month"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("Year"), Data_path.getProperty("Year"));

		ElementHelpers.clickElement(driver, Loc_path.getProperty("PurchaseButton"));
		ElementHelpers.clickElement(driver, Loc_path.getProperty("OkButton"));
	}
}
