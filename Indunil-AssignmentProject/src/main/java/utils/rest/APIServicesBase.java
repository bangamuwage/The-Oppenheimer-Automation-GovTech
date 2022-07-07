package utils.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import java.util.SortedMap;
import static io.restassured.RestAssured.given;

public abstract class APIServicesBase extends RestUtil {

    protected ObjectMapper objectMapper = new ObjectMapper();
    protected static String Environment = null;
    private static final String CORRELATION_ID="correlation-id";
    private static final Logger logger = Logger.getLogger(APIServicesBase.class);
    public APIServicesBase() {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
       
    }

    /**
     * @return the environment
     */
    public static String getEnvironment() {
        return Environment;
    }

    /**
     * @param environment the environment to set
     */
    public static void setEnvironment(String environment) {
    	Environment = environment;
    }
	/*
	 * public Response postRequest(JSONObject body,String baseURI, String
	 * relativeURI) {
	 * 
	 * try { setBaseURI(baseURI); setBasePath(relativeURI);
	 * 
	 * Response response = given() .body(body.toJSONString()) .when() .post();
	 * 
	 * // Clear Base Path resetBaseURI(); resetBasePath();
	 * 
	 * return response;
	 * 
	 * } catch (Exception ex) { logger.error(ex); throw ex; } }
	 */

    
	public Response postRequest(Map<String, Object> headers, String baseURI, String relativeURI) {

		try {
			setBaseURI(baseURI);
			setBasePath(relativeURI);

			Response response = given().headers(headers).when().post();

			// Clear Base Path
			resetBaseURI();
			resetBasePath();

			return response;

		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		}
	}

    public Response postRequest(JSONObject body, Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(body.toString());
            logger.info(CORRELATION_ID+":" +headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .headers(headers)
                            .body(body.toJSONString())
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    
    public Response postRequest(String body, Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response =
                    given()
                            .headers(headers)
                            .body(body)
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }

    public Response postRequest(JSONObject body, Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(body.toString());
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .body(body.toJSONString())
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    public Response postRequest(String body, Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .body(body)
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    public Response postRequest(JSONArray bodyArray, Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .body(bodyArray.toJSONString())
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    public Response postRequest(Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    
    public Response getRequest(Map<String, Object> headers, String baseURI) {

        try {
            setBaseURI(baseURI);

            Response response =
                    given()
                            .headers(headers)
                            .when()
                            .get();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }

    public Response getRequest(Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .headers(headers)
                            .when()
                            .get();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }


    public Response getRequest (String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            Response response =
                    given()
                            .when()
                            .get();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }

    public Response getRequest(Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {
        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .when()
                            .get();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }

    public Response putRequest(JSONObject body, Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(body.toString());
            Response response =
                    given()
                            .headers(headers)
                            .body(body.toJSONString())
                            .when()
                            .put();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    
    public Response putRequest( Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            RestUtil.setBaseURI(baseURI);
            RestUtil.setBasePath(relativeURI);

            Response response =
                    given()
                            .headers(headers)
                            .when()
                            .put();

            // Clear Base Path
            RestUtil.resetBaseURI();
            RestUtil.resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }


    public Response putRequest(JSONObject body, Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(body.toString());
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .body(body.toJSONString())
                            .when()
                            .put();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }



    public Response putRequest(Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .when()
                            .put();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    

    
    public Response putRequest(String body, Map<String, Object> headers, String baseURI, String relativeURI, Map<String, String> query) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            .queryParams(query)
                            .headers(headers)
                            .body(body)
                            .when()
                            .put();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }

    
    public Response deleteRequest(Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);

            Response response =
                    given()
                            .headers(headers)
                            .when()
                            .delete();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    public Response postRequest(JSONArray bodyArray, Map<String, Object> headers, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(CORRELATION_ID+":"+headers.get(CORRELATION_ID));
            Response response =
                    given()
                            
                            .headers(headers)
                            .body(bodyArray.toJSONString())
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();

            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    public Response postRequest(SortedMap<String, String> formUrlData, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(formUrlData.toString());
            Response response =
                    given()
                            .contentType(ContentType.URLENC)
                            .formParams(formUrlData)
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();
            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }
    public Response postRequest(Map<String, Object> headers,SortedMap<String, String> formUrlData, String baseURI, String relativeURI) {

        try {
            setBaseURI(baseURI);
            setBasePath(relativeURI);
            logger.info(formUrlData.toString());
            Response response =
                    given()
                            .headers(headers)
                            .contentType(ContentType.URLENC)
                            .formParams(formUrlData)
                            .when()
                            .post();

            // Clear Base Path
            resetBaseURI();
            resetBasePath();
            return response;

        } catch (Exception ex) {
        	logger.error(ex);
            throw ex;
        }
    }

}
