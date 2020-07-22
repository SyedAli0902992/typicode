package mobiquity.test.helper;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonHelper {
	
	
	/**
	 * This method is used to parse the test data json
	 * @param jsonName
	 * @return JSONObject
	 */
	public static JSONObject getParsedJsonAsString(String jsonName) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject) parser.parse(new FileReader("src/test/resources/TestData/"+jsonName+".json"));
			return jsonObj; 
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
