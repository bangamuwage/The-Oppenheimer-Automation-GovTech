package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.http.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.log4testng.Logger;

public abstract class ApiBase {

	private File file;
	private static JSONParser parser;

	private static final Logger logger = Logger.getLogger(ApiBase.class);
	
	public JSONObject getJSONBodyTemplate(String filename) throws IOException, ParseException, Exception {
		
		String testDataPath = "./src/test/java/requestBodyTemplate/PersonTemplate.json";

		try {
			
			file = new File(testDataPath);
			
			return (JSONObject) parser.parse(new FileReader(file));

		}catch (NullPointerException |FileNotFoundException e){
			logger.error(e);
			throw e;
		}
	}
}
