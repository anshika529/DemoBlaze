package com.atmecs.demoblaze.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtocartTest {
	Properties Locators;
	Properties Data;
	WebDriver driver;

	@BeforeMethod
	public void settingAndLaunchingDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anshika.negi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		FileInputStream locator = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Locators\\DemoBlaze.properties");
		Locators = new Properties();
		Locators.load(locator);
		FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Data\\DemoBlaze.properties");
		Data = new Properties();
		Data.load(data);
		
		driver.get(Locators.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

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


