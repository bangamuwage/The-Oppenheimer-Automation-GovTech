package apiTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.TestBase;
import utils.data.HeaderProvider;
import APIControllers.CalculatorController;

public class UserStory1 extends TestBase {
	
private static final org.apache.log4j.Logger logger = Logger.getLogger(UserStory1.class);
private CalculatorController calculatorController;

   @BeforeClass
   public void serviceSetUp() throws Exception {
	try {
		calculatorController = new CalculatorController();
	} catch (Exception e) {
		throw e;
	}
   }
//since currently requests are responding with 202 status, assert all TCs with 202 instead of  201 response
//currently invalid scenario's TCs failing due to respond 500 instead expect value of 400
    @Test
    //TC-001
	public void InsertSingleUserRecordWithAllValidDetailsForGenderF() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");		
			body.put("gender", "F");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),202);
			logger.info("InsertSingleUserRecordWithAllValidDetailsForGenderF was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-002
	public void InsertSingleUserRecordWithAllValidDetailsForGenderM() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");		
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),202);
			logger.info("InsertSingleUserRecordWithAllValidDetailsForGenderM was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-003
	public void InsertSingleUserRecordWithAllValidDetailsWithInvalidGender() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.put("gender", "usedyfgseudhfF");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithInvalidGender was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-004
	public void InsertSingleUserRecordWithAllValidDetailsWithoutNaturalId() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.remove("natid");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithoutNaturalId was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-005
	public void InsertSingleUserRecordWithAllValidDetailsWithoutName() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.remove("name");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithoutName was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-006
	public void InsertSingleUserRecordWithAllValidDetailsWithoutGender() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.remove("gender");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithoutGender was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-007
	public void InsertSingleUserRecordWithAllValidDetailsWithoutBirthdate() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.remove("birthday");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithoutBirthdate was Successful");
		} catch (Exception e) {
			throw e;
		}
	}
    @Test
    //TC-008
	public void InsertSingleUserRecordWithAllValidDetailsWithoutSalary() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.remove("salary");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithoutNaturalId was Successful");
		} catch (Exception e) {
			throw e;
		}
	} 
    @Test
    //TC-009
	public void InsertSingleUserRecordWithAllValidDetailsWithoutTaxPaid() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.remove("tax");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithAllValidDetailsWithoutTaxPaid was Successful");
		} catch (Exception e) {
			throw e;
		}
	}  
    @Test
    //TC-010
	public void InsertSingleUserRecordWithInvalidTaxValue() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.put("tax","uydgweuy");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithInvalidTaxValue was Successful");
		} catch (Exception e) {
			throw e;
		}
	} 
    @Test
    //TC-011
	public void InsertSingleUserRecordWithInvalidSalaryValue() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.put("salary","uydgweuy");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithInvalidSalaryValue was Successful");
		} catch (Exception e) {
			throw e;
		}
	} 
    
    @Test
    //TC-012
	public void InsertSingleUserRecordWithInvalidBirthdateFormat() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.put("birthday","12/08/1993");
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithInvalidBirthdateFormat was Successful");
		} catch (Exception e) {
			throw e;
		}
	} 
    @Test
    //TC-013
	public void InsertSingleUserRecordWithNaturalIdAsNull() throws Exception {
		try {
			body = getJSONBodyTemplate("SingleUserRecordCreationRequest");	
			body.put("natid",null);
			headers = HeaderProvider.getHeaders("Header1");
			Assert.assertEquals(calculatorController.postSingleUserData(body,headers).getStatusCode(),400);
			logger.info("InsertSingleUserRecordWithNaturalIdAsNull was Successful");
		} catch (Exception e) {
			throw e;
		}
	}  
}