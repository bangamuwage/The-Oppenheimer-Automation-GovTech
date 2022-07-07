package apiTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.TestBase;
import pageObject.TaxDispensepage;
import pageObject.cashDispensedPage;

public class UserStory5 extends TestBase {
	
private static final org.apache.log4j.Logger logger = Logger.getLogger(UserStory5.class);
private cashDispensedPage cashDispensedPage;
private TaxDispensepage TaxDispensepage;
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
//TC-031
public void verifyDispalyingOfCashdispenseButton() throws Exception {
    try {
    	logger.info("## Start | verifyDispalyingOfCashdispenseButton ##" + this.getClass().getName());
    	TaxDispensepage= new TaxDispensepage(driver);    	
    	Assert.assertEquals(TaxDispensepage.getColorOfDispenseButton(), "#dc3545");
    	Assert.assertTrue(TaxDispensepage.getTextOfDispenseButton());
    	logger.info("## Fail | testSetup ##" + this.getClass().getName());
    } catch (Exception ex) {
    	logger.info("## Fail | verifyDispalyingOfCashdispenseButton ##" + this.getClass().getName());
        throw ex;
    }
}
@Test(dependsOnMethods = {"verifyDispalyingOfCashdispenseButton"})
//TC-032
public void verifyBehaviourOfCashdispenseButton() throws Exception {
  try {
  	logger.info("## Start | verifyBehaviourOfCashdispenseButton ##" + this.getClass().getName());
  	TaxDispensepage.clickTaxDispenseButton(); 
  	logger.info("## Fail | testSetup ##" + this.getClass().getName());
  } catch (Exception ex) {
  	logger.info("## Fail | verifyBehaviourOfCashdispenseButton ##" + this.getClass().getName());
      throw ex;
  }
}
//TC-033
@Test(dependsOnMethods = {"verifyBehaviourOfCashdispenseButton"})
public void verifyCashDispenseTextDisplayAfterrDispensed() throws Exception {
    try {
    	logger.info("## Start | verifyCashDispenseTextDisplayAfterrDispensed ##" + this.getClass().getName());
    	cashDispensedPage= new cashDispensedPage(driver);
        Assert.assertTrue(cashDispensedPage.isCashDispensedTxtDisplayed());  
    	logger.info("## Fail | testSetup ##" + this.getClass().getName());
    } catch (Exception ex) {
    	logger.info("## Fail | verifyCashDispenseTextDisplayAfterrDispensed ##" + this.getClass().getName());
        throw ex;
    }
}
}