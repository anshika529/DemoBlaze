package com.atmecs.demoblaze.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
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
		FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Data\\DemoBlaze.properties\\");
		Data = new Properties();
		Data.load(data);

		driver.get(Locators.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 2)

	public void login() throws InterruptedException, IOException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id(Locators.getProperty("LoginId"))).click();
		driver.findElement(By.cssSelector(Locators.getProperty("Login_User"))).sendKeys(Data.getProperty("UsernameLogin"));
		driver.findElement(By.xpath(Locators.getProperty("Login_Password"))).sendKeys(Data.getProperty("PasswordLogin"));
		driver.findElement(By.xpath(Locators.getProperty("LoginButton"))).click();
		Thread.sleep(2000);
		driver.close();

	}

}
