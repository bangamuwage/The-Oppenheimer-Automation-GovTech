package apiTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.TestBase;
import utils.data.TestDataReader;
import APIControllers.CalculatorController;
import APIResponseDTO.TaxReliefArrayResponseDTO;

public class UserStory4 extends TestBase {
	
private static final org.apache.log4j.Logger logger = Logger.getLogger(UserStory4.class);
private TaxReliefArrayResponseDTO taxReliefArrayResponseDTO;
private CalculatorController calculatorController;
private TestDataReader testDataReader;
@BeforeClass
public void serviceSetUp() throws Exception {
	try {
		calculatorController = new CalculatorController();
		testDataReader = new TestDataReader();
	} catch (Exception e) {
		throw e;
	}
}
    @Test
    //TC-025
	public void RetriveListOfTaxReliefDetails() throws Exception {
		try {
			
			taxReliefArrayResponseDTO = calculatorController.viewTaxReliefDetails();
			Assert.assertEquals(taxReliefArrayResponseDTO.getStatusCode(),200);
			Assert.assertEquals(taxReliefArrayResponseDTO.getTaxRelief().size(),24);
			Assert.assertNotNull(taxReliefArrayResponseDTO.getTaxRelief().get(0).getName());
			Assert.assertNotNull(taxReliefArrayResponseDTO.getTaxRelief().get(0).getNatid());
			Assert.assertNotNull(taxReliefArrayResponseDTO.getTaxRelief().get(0).getRelief());
			logger.info("RetriveListOfTaxReliefDetails was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
   
    @Test
    //TC-026
  	public void verifyNatIDMaskedHigherThan_Fourcharacters() throws Exception {
  		try {
  			taxReliefArrayResponseDTO = calculatorController.viewTaxReliefDetails();
  			
  			for(int i=0;i< taxReliefArrayResponseDTO.getTaxRelief().size();i++)
  			{
  				String actualId = taxReliefArrayResponseDTO.getTaxRelief().get(i).getNatid();
  				Assert.assertTrue(actualId.matches("^[^$]{4}\\$+$"));
  			}			
  			logger.info("verifyNatIDMaskedHigherThan_Fourcharacters was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
       
    @Test
    //TC-027
  	public void verifyTheFormulaOfTaxReleaseCalculation () throws Exception {
  		try {
  			TaxReliefArrayResponseDTO taxReliefArrayResponseDTO = calculatorController.viewTaxReliefDetails();
  			Assert.assertTrue(testDataReader.verifyTaxvalue(taxReliefArrayResponseDTO));	
  			logger.info("verifyTheFormulaOfTaxReleaseCalculation was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
}





















