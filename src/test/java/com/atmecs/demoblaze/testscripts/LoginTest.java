package com.atmecs.demoblaze.testscripts;

import org.testng.annotations.Test;

import com.atmecs.demoblaze.pages.Loginpage;
import com.atmecs.demoblaze.testsuit.BaseTest;

public class LoginTest extends BaseTest {
	@Test(priority = 2)
	public void Login() {
		Loginpage obj = new Loginpage();
		obj.loginactions();
	}
}
