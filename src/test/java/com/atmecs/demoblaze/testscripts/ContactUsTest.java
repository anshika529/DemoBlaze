package com.atmecs.demoblaze.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.atmecs.demoblaze.testsuit.Base;

public class ContactUsTest extends Base {

		@Test(priority = 3)
		public void contact() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Locators.getProperty("ContactLink"))).click();
			driver.findElement(By.cssSelector(Locators.getProperty("Recipient_Email"))).sendKeys(Data.getProperty("Recipient_Mail"));
			driver.findElement(By.cssSelector(Locators.getProperty("Recipient_name"))).sendKeys(Data.getProperty("Recipient_Name"));
			driver.findElement(By.id(Locators.getProperty("Messageid"))).sendKeys(Data.getProperty("Message"));
			driver.findElement(By.xpath(Locators.getProperty("SendMessage"))).click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.close();

		}

}
