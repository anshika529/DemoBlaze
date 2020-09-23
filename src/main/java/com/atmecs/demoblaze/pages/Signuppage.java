package com.atmecs.demoblaze.pages;

import java.util.Properties;

import com.atmecs.demoblaze.constants.Constants;
import com.atmecs.demoblaze.helpers.ElementHelpers;
import com.atmecs.demoblaze.testsuit.BaseTest;
import com.atmecs.demoblaze.utils.PropertyReader;


public class Signuppage extends BaseTest {
	Properties Loc_path;
	Properties Data_path;
	
 public void signupactions()
 {
	 Loc_path= PropertyReader.readProperties(Constants.Locator_file);
	 Data_path= PropertyReader.readProperties(Constants.TestData_file);
	 ElementHelpers.clickElement(driver, Loc_path.getProperty("Signup") );
	 ElementHelpers.sendkeys(driver, Loc_path.getProperty("SignupUsername"), Data_path.getProperty("SignupUsername"));
	 ElementHelpers.sendkeys(driver, Loc_path.getProperty("SignupPassword"), Data_path.getProperty("SignupPassword"));
	 ElementHelpers.clickElement(driver, Loc_path.getProperty("SignupButton"));
 }


}
