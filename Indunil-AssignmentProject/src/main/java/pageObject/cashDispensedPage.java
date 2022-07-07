package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.apache.log4j.Logger;
import test.base.TestBase;

public class cashDispensedPage extends TestBase{

	
	private static final org.apache.log4j.Logger logger = Logger.getLogger(cashDispensedPage.class);
		
	public cashDispensedPage(WebDriver driver) {
		this.driver = driver;
	}
	WebElement txtCashDispensed = driver.findElement(By.xpath("//div[text()='Cash dispensed']"));

	
	 public boolean isCashDispensedTxtDisplayed() throws Exception {
	        try {
	            logger.info("## Start | isCashDispensedTxtDisplayed ##" + this.getClass().getName());
	            return txtCashDispensed.isDisplayed();
	        } catch (Exception ex) {
	        	 logger.info("## Fail | isCashDispensedTxtDisplayed ##" + this.getClass().getName());
	            throw ex;
	        }
	    }	
}
