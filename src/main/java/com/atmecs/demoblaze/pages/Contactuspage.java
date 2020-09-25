package com.atmecs.demoblaze.pages;

import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.demoblaze.constants.Constants;
import com.atmecs.demoblaze.helpers.ElementHelpers;
import com.atmecs.demoblaze.testsuit.BaseTest;
import com.atmecs.demoblaze.utils.PropertyReader;

public class Contactuspage extends BaseTest {

	Properties Loc_path;
	Properties Data_path;

	public void contactusactions() {
		Loc_path = PropertyReader.readProperties(Constants.Locator_file);
		Data_path = PropertyReader.readProperties(Constants.TestData_file);

		ElementHelpers.clickElement(driver, Loc_path.getProperty("Contact"));

		ElementHelpers.sendkeys(driver, Loc_path.getProperty("ContactEmail"), Data_path.getProperty("ContactEmail"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("ContactName"), Data_path.getProperty("ContactName"));
		ElementHelpers.sendkeys(driver, Loc_path.getProperty("Message"), Data_path.getProperty("Message"));

		ElementHelpers.clickElement(driver, Loc_path.getProperty("SendMessageButton"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}