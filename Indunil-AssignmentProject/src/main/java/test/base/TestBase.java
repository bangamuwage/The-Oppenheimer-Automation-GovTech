package test.base;

import utils.data.Config;
import utils.data.HeaderProvider;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;

public  class TestBase {

	private static String templateBodyPath;
	private static String templateHeaderPath;
	private static String testDataPath;
	private static String testMediaFileLocation ;
	private static JSONParser parser;
	private File file;
	private Random random = new Random();
	protected JSONObject body;
	protected JSONObject data;
	protected Map<String, Object> headers;
	protected Map<String, JSONObject> value;
	private static final Logger logger = Logger.getLogger(TestBase.class);
	protected static String enviroment;
	protected JSONArray bodyArray;
	public static WebDriver driver;
	
	@BeforeSuite(alwaysRun=true)
	public static void startUp() throws Exception {

		try {
			Config.setConfigFilePath("/Config/configuration.properties");
			templateBodyPath = Config.getProperty("template.body.path");
			templateHeaderPath = Config.getProperty("template.header.path");
			testDataPath = Config.getProperty("template.data.path");
			enviroment=Config.getProperty("enviroment");
			PropertyConfigurator.configure("src/test/resources/Logger/log4j.properties");
			if(templateHeaderPath != null)
				HeaderProvider.setHeaderProviderFilePath(templateHeaderPath);
			parser = new JSONParser();
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	public JSONObject getJSONBodyTemplate(String filename) throws IOException, ParseException {

		try {
			file = new File(templateBodyPath, filename);
			return (JSONObject) parser.parse(new FileReader(file));

		}catch (NullPointerException |FileNotFoundException e){
			logger.error(e);
			throw e;
		}
	}

	//@SuppressWarnings("unchecked")
	public JSONObject getJSONTestData(String filename ,String dataName) throws IOException, ParseException {

		try {
			file = new File(testDataPath, filename);
			value = (Map<String, JSONObject>)parser.parse(new FileReader(file));
			return value.get(dataName);

		}catch (NullPointerException |FileNotFoundException e){
			logger.error(e);
			throw e;
		}

	}

	public String getTestData(String propertyName) throws IOException, ParseException {
		return getJSONTestData("TestData","data").get(propertyName).toString();
	}

//	@SuppressWarnings("unchecked")
	public List<JSONObject> getJSONTestData(String filename) throws IOException, ParseException {
		try {
			file = new File(testDataPath, filename);
			return (JSONArray) parser.parse(new FileReader(file));
		}catch (NullPointerException |FileNotFoundException e){
			logger.error(e);
			throw e;
		}
	}

	//@SuppressWarnings("unchecked")
	public JSONObject getJSONBodyTemplate(String filename ,String dataName) throws IOException, ParseException {

		try {
			file = new File(templateBodyPath, filename);
			value = (Map<String, JSONObject>)parser.parse(new FileReader(file));
			return  value.get(dataName);

		}catch (NullPointerException |FileNotFoundException e){
			logger.error(e);
			throw e;
		}
	}
	
	public JSONArray getJSONBodyArrayTemplate(String filename) throws IOException, ParseException {
		try {
			file = new File(templateBodyPath, filename);
			return (JSONArray) parser.parse(new FileReader(file));

		}catch (NullPointerException |FileNotFoundException e){
			logger.error(e);
			throw e;
		}
	}
	 public String getTestDataFilePath(String dataFolderName) throws Exception {
	        try {
	            File file = new File(testDataPath, dataFolderName);
	            return file.getAbsolutePath();
	        } catch (Exception ex) {
	            throw ex;
	        }
	    }
	 
   public WebDriver launchBrowser() throws Exception {
        try {
        	logger.info("## Start | launchBrowserAndNavigate() ## " + this.getClass().getName());
           
            String DriverPath = new File("src/test/resources/chromedriver.exe").getAbsolutePath();
            System.setProperty("webdriver.chrome.driver",DriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/");
			return driver;
        } catch (Exception ex) {
        	logger.info("## Fail | launchBrowserAndNavigate() ## " + this.getClass().getName());
            throw ex;
        }
    }
    
	@AfterSuite
    public void quitDriver() throws Exception {

        try {
        	logger.info("## Start | quitDriver() ## " + this.getClass().getName());
            if (driver != null)
            	driver.quit();

        } catch (Exception e) {
        	logger.info("## Fail | quitDriver() ## " + this.getClass().getName());
            throw e;
        }
    }
	
	/***
	 * Convert to UTC Date based on the given Timezone
	 * Required for GLP integration
	 */
    public String getDate(Long daysToDue,String courseTimeZone) {
        DateTimeFormatter etFormatx = DateTimeFormatter.ofPattern("M/d/yyyy");
        ZoneId courseZoneId1 = ZoneId.of(courseTimeZone);
        Instant instant = Instant.ofEpochMilli( daysToDue );
        ZonedDateTime zdt = ZonedDateTime.ofInstant ( instant , courseZoneId1 );
        ZonedDateTime currentEastern = zdt.withZoneSameInstant(courseZoneId1);
        return etFormatx.format ( currentEastern );
        
    }
   
    public String getDueDate(Long daysToStart) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        LocalDateTime startDateTime = LocalDateTime.now().plusDays(daysToStart);
        return dateTimeFormatter.format ( startDateTime );
        
    }
	
}
