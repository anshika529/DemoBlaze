package com.atmecs.demoblaze.testscripts;

import org.testng.annotations.Test;

import com.atmecs.demoblaze.pages.Contactuspage;
import com.atmecs.demoblaze.testsuit.BaseTest;

public class ContactUsTest extends BaseTest {

	@Test(priority = 3)
	public void contactus() {
		Contactuspage cup = new Contactuspage();
		cup.contactusactions();
	}

}
