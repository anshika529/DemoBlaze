package com.atmecs.demoblaze.testscripts;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.atmecs.demoblaze.testsuit.Base;

public class AddtocartTest extends Base {
	@Test(priority = 4)
	public void addtoCart() throws InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.className(Locators.getProperty("Home"))).click();
		driver.findElement(By.xpath(Locators.getProperty("MobileLink"))).click();
		driver.findElement(By.xpath(Locators.getProperty("AddToCart"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(Locators.getProperty("CartLink"))).click();
		Thread.sleep(60);

		driver.findElement(By.xpath(Locators.getProperty("PlaceOrder"))).click();
		driver.findElement(By.id(Locators.getProperty("Name_id"))).sendKeys(Data.getProperty("Name"));
		driver.findElement(By.id(Locators.getProperty("Country_id"))).sendKeys(Data.getProperty("Country"));
		driver.findElement(By.id(Locators.getProperty("City_id"))).sendKeys(Data.getProperty("City"));
		driver.findElement(By.id(Locators.getProperty("Card_id"))).sendKeys(Data.getProperty("Card"));
		driver.findElement(By.id(Locators.getProperty("Month_id"))).sendKeys(Data.getProperty("Month"));
		driver.findElement(By.id(Locators.getProperty("Year_id"))).sendKeys(Data.getProperty("Year"));
		driver.findElement(By.xpath(Locators.getProperty("ClickPlaceOrder"))).click();

		driver.findElement(By.xpath(Locators.getProperty("OKButton"))).click();
		driver.close();

	}

}


