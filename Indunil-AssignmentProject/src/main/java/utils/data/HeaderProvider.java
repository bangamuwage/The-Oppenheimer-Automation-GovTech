package utils.data;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

public class HeaderProvider {

	private static Map<String, JSONObject> headers;
	private static HeaderProvider instance;
	private static String path;
	private static final Logger logger = Logger.getLogger(HeaderProvider.class);
	private HeaderProvider() {

		try {
			File file = new File(path);
			JSONParser parser = new JSONParser();
			headers = (Map<String, JSONObject>) parser.parse(new FileReader(file));
		
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static void setHeaderProviderFilePath(String headerProviderFilePath) {
		path = headerProviderFilePath;
		instance = null;
	}

	public static Map<String, Object> getHeaders(String templateName) {
			instance = new HeaderProvider();
		return  (Map<String, Object>) headers.get(templateName);
	}
	
	public static HeaderProvider getInstance() {
		return instance;
	}

	public static void setInstance(HeaderProvider instance) {
		HeaderProvider.instance = instance;
	}

}
