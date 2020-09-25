package com.atmecs.demoblaze.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementHelpers {

	public static void clickElement(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void sendkeys(WebDriver driver, String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

}
