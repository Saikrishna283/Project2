package org.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Robot r;
	public Actions a;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public Alert al;
	public static void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();	
	}
	public static  void url(String url) {
		driver.get(url);
	}
	public static void sendKeys(WebElement element,String txt) {
		element.sendKeys(txt);
	}
	private void maximize() {
	driver.manage().window().maximize();
	}
	private String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	private String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static void sendKey(WebElement element,String txt) {
		element.sendKeys(txt);
	}
	private void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static  void toClick(WebElement element) {
		element.click();
	}
	private String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	private void getAttribute(WebElement element,String attributename) {
		element.getAttribute(attributename);
	}
	private void toPerformMoveToElemant(WebElement element) {
		a.moveToElement(element);
	}
	private void dragAndDrop(WebElement src,WebElement dest) {
		a.dragAndDrop(src, dest);
	}private void pressEnter() {
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}private void pressTab() {
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}private void pressCopy() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}private void pressPaste() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}private void doubleClick(WebElement element) {
		a.doubleClick(element);
	}private void rightClick(WebElement element) {
		a.contextClick(element).perform();
	}private void pressCut() {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
	private void selectAll() {
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_A);
} 	private void alertAccecpt() {
	al.accept();
}	private void aletDissmis() {
	al.dismiss();
}	private void alertSendKeys(String keys) {
	al.sendKeys(keys);
}	public static void javaScriptInsertValue(String keys,WebElement element) {
	js.executeScript("arguments[0].setAttribute(value,'keys')",element);
}

	
	
	

	
	public static  String readExcel(int rownum,int colnum) throws IOException {
		File f=new File("C:\\Users\\RC3 IT\\eclipse-workspace\\Maven\\Excelsheets\\EmpId.xlsx");
		
		FileInputStream fil=new FileInputStream(f);
		
		Workbook book=new XSSFWorkbook(fil);
		
		Sheet sh = book.getSheet("Sheet1");
		Row r = sh.getRow(rownum);
		Cell c = r.getCell(colnum);
		String value="";
		int ct = c.getCellType();
		
		if (ct==1) {
			 value = c.getStringCellValue();
		}else if (DateUtil.isCellDateFormatted(c) ) {
			
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat("dd-mm-yyyy");
			 value = s.format(s);
		}else {
			double dd = c.getNumericCellValue();
			long l=(long) dd;
			 value = String.valueOf(dd);
		}
		return value;
	}
	
	public static void writeExcel() throws IOException {
		
		File f=new File("C:\\Users\\RC3 IT\\eclipse-workspace\\Maven\\Excelsheets\\book1.xlsx");
		
		Workbook book=new XSSFWorkbook();
		
		Sheet sheet = book.createSheet("Data");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		
		cell.setCellValue("Framework");
		
		FileOutputStream fil=new FileOutputStream(f);
		book.write(fil);
		
		
		
		
		
		
		
		

	}
	
	
	

}
