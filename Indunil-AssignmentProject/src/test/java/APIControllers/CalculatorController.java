package APIControllers;
import utils.constant.RelativeURLs;
import utils.data.Config;
import utils.rest.APIServicesBase;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import APIResponseDTO.TaxReliefArrayResponseDTO;
import APIResponseDTO.TaxReliefResponseDTO;

public class CalculatorController extends APIServicesBase {

    private String baseURI;
    private TaxReliefArrayResponseDTO taxReliefArrayResponseDTO;
    private TaxReliefResponseDTO[] taxReliefResponseDTO;
   
    public CalculatorController() {
        this.baseURI = Config.getProperty("baseserviceurl");
    }

    public Response postSingleUserData(JSONObject body,Map<String, Object> headers) throws Exception {

        try {
            Response response = postRequest(body,headers,baseURI,RelativeURLs.ADD_SINGLE_USER_RECORD);

            return response;

        } catch (Exception e) {
            throw e;
        }
    }
    
    public Response postMultipleUserData(JSONArray body,Map<String, Object> headers) throws Exception {

        try {
            Response response = postRequest(body,headers,baseURI,RelativeURLs.ADD_MULTIPLE_USER_RECORD);

            return response;

        } catch (Exception e) {
            throw e;
        }
    }
    
    public TaxReliefArrayResponseDTO viewTaxReliefDetails() throws Exception {
    	        try {
    	            Response response = getRequest(baseURI, RelativeURLs.GET_TAXRELIEF_RECORDS);

    	            if (response.statusCode() == 200) {
    	            	taxReliefArrayResponseDTO = new TaxReliefArrayResponseDTO();
    	            	taxReliefResponseDTO = objectMapper.readValue(response.asString(), TaxReliefResponseDTO[].class);
    	                taxReliefArrayResponseDTO.setTaxRelief(Arrays.asList(taxReliefResponseDTO));
    	            } else
    	            	taxReliefArrayResponseDTO = new TaxReliefArrayResponseDTO();
    	            taxReliefArrayResponseDTO.setResponse(response);

    	        } catch (Exception ex) {
    	            throw ex;
    	        }
    	        return taxReliefArrayResponseDTO;
    	    }

}




























