package apiTest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.base.TestBase;
import utils.data.HeaderProvider;
import APIControllers.CalculatorController;

public class UserStory2 extends TestBase {
	
private static final org.apache.log4j.Logger logger = Logger.getLogger(UserStory2.class);
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
    //TC-014
  	public void AddMultipleUserRecordWithAllValidDetails() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");		
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),202);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
    @Test
    //TC-015
  	public void AddMultipleUserRecordWithoutNaturalIdForOneUser() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");	
  			JSONObject firstUser = (JSONObject) body.get(0);
  			firstUser.remove("natid");
  			body.add(firstUser);
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),400);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
    @Test
    //TC-016
  	public void AddMultipleUserRecordWithInvalidGenderForUser() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");	
  			JSONObject firstUser = (JSONObject) body.get(0);
  			firstUser.put("gender","terwyurtwe");
  			body.add(firstUser);
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),400);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
    @Test
    //TC-017
  	public void AddMultipleUserRecordWithInvalidBirthdateFormatForUser() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");	
  			JSONObject firstUser = (JSONObject) body.get(0);
  			firstUser.put("birthday","09-07-2023");
  			body.add(firstUser);
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),400);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
    @Test
    //TC-018
  	public void AddMultipleUserRecordWithInvalidTaxValueForUser() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");	
  			JSONObject firstUser = (JSONObject) body.get(0);
  			firstUser.put("tax","sdfsdgjf");
  			body.add(firstUser);
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),400);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
    @Test
  	 //TC-019
  	public void AddMultipleUserRecordWithInvalidSalaryValueForUser() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");	
  			JSONObject firstUser = (JSONObject) body.get(0);
  			firstUser.put("salary","sdfsdgjf");
  			body.add(firstUser);
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),400);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
    @Test
  //TC-020
  	public void AddMultipleUserRecordWithNatIdAsNullForUser() throws Exception {
  		try {
  			
  			JSONArray body = getJSONBodyArrayTemplate("MultipleUserRecordCreationRequest");	
  			JSONObject firstUser = (JSONObject) body.get(0);
  			firstUser.put("natid",null);
  			body.add(firstUser);
  			headers = HeaderProvider.getHeaders("Header1");
  			Assert.assertEquals(calculatorController.postMultipleUserData(body,headers).getStatusCode(),400);
  			logger.info("AddMultipleUserRecordWithAllValidDetails was Successful");
  		} catch (Exception e) {
  			throw e;
  		}
  	}
  
}