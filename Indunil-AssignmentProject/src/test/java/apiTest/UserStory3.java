package apiTest;

import java.io.File;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.TestBase;
import utils.data.HeaderProvider;
import APIControllers.CalculatorController;
import pageObject.TaxDispensepage;

public class UserStory3 extends TestBase {
	
private static final org.apache.log4j.Logger logger = Logger.getLogger(UserStory3.class);
private String fileLocation;
private TaxDispensepage TaxDispensepage;
private TestBase TestBase;
static WebDriver driver;


@BeforeClass
public void testSetUp() throws Exception {
    try {
    	logger.info("## Start | testSetUp ##" + this.getClass().getName());
    	driver = launchBrowser();      	
    	logger.info("## Fail | testSetup ##" + this.getClass().getName());
    } catch (Exception ex) {
    	logger.info("## Fail | testSetUp ##" + this.getClass().getName());
        throw ex;
    }
}

@Test
//TC-022
public void uploadCSVFileWithRrequiredDataAndDetails() throws Exception {
    try {
    	logger.info("## Start | uploadCSVFile ##" + this.getClass().getName());  
    	TaxDispensepage = new TaxDispensepage(driver);
    	fileLocation = getTestDataFilePath("userRecords.csv");  
        TaxDispensepage.uploadFile(fileLocation);  
    } catch (Exception ex) {
    	logger.info("## Fail | uploadCSVFileWitRrequiredDataAndDetails ##" + this.getClass().getName());
        throw ex;
    }
}
@Test
//TC-023
public void uploadCSVFileWithInvalidRrequiredDataAndDetails() throws Exception {
    try {
    	logger.info("## Start | uploadCSVFile ##" + this.getClass().getName());  
    	TaxDispensepage = new TaxDispensepage(driver);
    	fileLocation = getTestDataFilePath("invalidUserRecords.csv");  
        TaxDispensepage.uploadFile(fileLocation);  
    } catch (Exception ex) {
    	logger.info("## Fail | uploadCSVFile ##" + this.getClass().getName());
        throw ex;
    }
}
@Test
//TC-023
public void uploadInvalidFileFormat() throws Exception {
  try {
  	logger.info("## Start | uploadInvalidFileFormat ##" + this.getClass().getName());  
  	TaxDispensepage = new TaxDispensepage(driver);
  	fileLocation = getTestDataFilePath("Sample test data.docx");  
    TaxDispensepage.uploadFile(fileLocation);  
  } catch (Exception ex) {
  	logger.info("## Fail | uploadInvalidFileFormat ##" + this.getClass().getName());
      throw ex;
  }
}

}