package com.atmecs.demoblaze.testscripts;

import org.testng.annotations.Test;

import com.atmecs.demoblaze.pages.Addtocartpage;

import com.atmecs.demoblaze.testsuit.BaseTest;

public class AddtocartTest extends BaseTest {
	@Test(priority = 4)
	public void addtoCart() throws InterruptedException {
		Addtocartpage atc = new Addtocartpage();
		atc.addtocartactions();

	}

}
