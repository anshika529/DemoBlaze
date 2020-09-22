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

public class ContactUsTest {

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
