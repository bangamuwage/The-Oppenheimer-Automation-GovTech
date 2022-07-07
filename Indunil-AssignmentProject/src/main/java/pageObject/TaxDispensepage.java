package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.apache.log4j.Logger;
import test.base.TestBase;

public class TaxDispensepage extends TestBase{

	
	private static final org.apache.log4j.Logger logger = Logger.getLogger(TaxDispensepage.class);
		
	public TaxDispensepage(WebDriver driver) {
		this.driver = driver;
	}
	WebElement btnBrowse = driver.findElement(By.xpath("//div[@class='custom-file']/descendant::input"));
	WebElement btnTaxDispense = driver.findElement(By.xpath("//a[text()='Dispense Now']"));
	WebElement btnTaxReliefRefresh = driver.findElement(By.xpath("//div[@id='contents']/descendant::button[contains(text(),'Refresh Tax Relief Table')]"));  
	WebElement tdTaxDetails = driver.findElement(By.xpath("//tr/td[contains(text(),'{1}')]"));

	
	 public void uploadFile(String fileLocation) throws Exception {
	        try {
	            logger.info("## Start | uploadFile ##" + this.getClass().getName());
	            btnBrowse.sendKeys(fileLocation);
	        } catch (Exception ex) {
	        	 logger.info("## Fail | uploadFile ##" + this.getClass().getName());
	            throw ex;
	        }
	    }
	 
		public String getColorOfDispenseButton() throws Exception {
			try {
				logger.info("## Start | uploadFile ##" + this.getClass().getName());
				return Color.fromString(btnTaxDispense.getCssValue("background-color")).asHex();
			} catch (Exception e) {
				throw new Exception("Failed : getColorOfDispenseButton()" + e.getLocalizedMessage());
			}
		}

		public boolean getTextOfDispenseButton() throws Exception {
			try {
				logger.info("## Start | uploadFile ##" + this.getClass().getName());
				return btnTaxDispense.getText().contentEquals("Dispense Now");
			} catch (Exception e) {
				throw new Exception("Failed : getColorOfDispenseButton()" + e.getLocalizedMessage());
			}
		}

		public void clickTaxDispenseButton() throws Exception {
			try {
				logger.info("## Start | clickTaxReliefButton ##" + this.getClass().getName());
				btnTaxDispense.click();
			} catch (Exception ex) {
				logger.info("## Fail | clickTaxReliefButton ##" + this.getClass().getName());
				throw ex;
			}
		}
		public void clickTaxReliefRefreshButton() throws Exception {
			try {
				logger.info("## Start | clickTaxReliefRefreshButton ##" + this.getClass().getName());
				btnTaxReliefRefresh.click();
			} catch (Exception ex) {
				logger.info("## Fail | clickTaxReliefRefreshButton ##" + this.getClass().getName());
				throw ex;
			}
		}
		
}
