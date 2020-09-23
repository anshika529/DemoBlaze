package com.atmecs.demoblaze.testsuit;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.atmecs.demoblaze.constants.Constants;
import com.atmecs.demoblaze.utils.PropertyReader;

public class BaseTest {
	public static Properties properties;
	public static WebDriver driver;
	String baseUrl;
	String browser;

	@BeforeTest
	public void invokeBrowser() {

	properties = PropertyReader.readProperties(Constants.TestData_file);

	baseUrl = properties.getProperty("url");
	browser = properties.getProperty("Browser");

	System.setProperty("webdriver.chrome.driver", Constants.Chrome_file);
	if (browser.equalsIgnoreCase("chrome")) {
	driver = new ChromeDriver();
	}

	driver.get(baseUrl);
	driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}

	@AfterTest
	public void closeBrowser() {
	driver.close();
	}
}
