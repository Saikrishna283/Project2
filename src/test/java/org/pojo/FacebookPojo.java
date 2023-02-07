package org.pojo;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FacebookPojo extends BaseClass {
	
	
	
	public FacebookPojo() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement usertext;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement userpassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement buttonlogin;

	public WebElement getUsertext() {
		return usertext;
	}

	public WebElement getUserpassword() {
		return userpassword;
	}

	public WebElement getButtonlogin() {
		return buttonlogin;
	}
	
	
	
	
	}

	

