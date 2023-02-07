package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBussBookPassenger extends BaseClass {

	
	RedBussBookPassenger(){
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@id='signin-block\']")
	WebElement Login;
		
	@FindBy(xpath="//li[text()='Sign In/Sign Up']")
	WebElement signup;
	
	@FindBy(xpath="(//div[text()='Facebook'])[2]")
	WebElement facebook;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement fillemail;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement fillpassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement clicklogin;
	
	
	
	
	
}
