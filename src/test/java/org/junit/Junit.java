package org.junit;

import java.util.Date;

import org.base.BaseClass;

public class Junit extends BaseClass {
	
	@BeforeClass
	
	public static void befClass() {
		Date d=new Date();
		System.out.println(d);
	}
	
	@AfterClass
	
	public static void aftClass() {
		Date d=new Date();
		System.out.println(d);
	}
	@Before
	
	public void browserLaunch() {
		launchBrowser();
		url("https://en-gb.facebook.com/");
	}
	@Test
	public void testCase1() {
		
	
	}
	@After
	public void aft() {
		quit();
	}
	
	
	
}
