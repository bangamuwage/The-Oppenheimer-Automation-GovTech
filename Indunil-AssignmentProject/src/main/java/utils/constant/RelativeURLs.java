package utils.constant;

public class RelativeURLs {
	  private RelativeURLs() {
		    throw new IllegalStateException("RelativeURLs class");
		  }
	  
    public static final String ADD_SINGLE_USER_RECORD = "/calculator/insert";
    public static final String ADD_MULTIPLE_USER_RECORD = "/calculator/insertMultiple";
    public static final String GET_TAXRELIEF_RECORDS = "/calculator/taxRelief";
}
