package org.test;

import java.util.Date;

import org.base.BaseClass;
import org.testng.annotations.Test;

public class TestNg extends BaseClass{
	
	@Test
	 private void tc1() {
		Date d=new Date();
		System.out.println(d);
	 launchBrowser();
	 

	}
	
	
	
	

}
