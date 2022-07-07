package utils.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import APIResponseDTO.TaxReliefArrayResponseDTO;
import APIResponseDTO.TaxReliefResponseDTO;
import test.base.TestBase;

public class TestDataReader extends TestBase {

	public boolean verifyTaxvalue(TaxReliefArrayResponseDTO taxReliefArrayResponseDTO) throws Exception {

		Boolean status = true;

		JSONArray getTaxReliefData = getJSONBodyArrayTemplate("getTaxReliefData");

		for (int i = 0; i < getTaxReliefData.size(); i++) {

			JSONObject expectedDataObj = (JSONObject) getTaxReliefData.get(i);

			for (int j = 0; j < taxReliefArrayResponseDTO.getTaxRelief().size(); j++) {

				TaxReliefResponseDTO actualDataObj = taxReliefArrayResponseDTO.getTaxRelief().get(j);

				if (actualDataObj.getNatid().equals(expectedDataObj.get("natid"))) {

				  status = actualDataObj.getRelief().equals(expectedDataObj.get("relief"));
					
					 if(status = false) { 
						break;
					 
					  }
				}
			}
		}
		return status;
	}
}
