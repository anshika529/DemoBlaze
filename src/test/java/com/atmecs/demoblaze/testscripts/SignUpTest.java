package com.atmecs.demoblaze.testscripts;

import org.testng.annotations.Test;

import com.atmecs.demoblaze.pages.Signuppage;
import com.atmecs.demoblaze.testsuit.BaseTest;

public class SignUpTest extends BaseTest {

	@Test(priority = 1)
	public void signup() {
		Signuppage sp = new Signuppage();
		sp.signupactions();
	}

}
