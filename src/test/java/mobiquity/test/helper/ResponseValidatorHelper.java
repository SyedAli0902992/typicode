package mobiquity.test.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class ResponseValidatorHelper {
	
	/**
	 * This method is used to get user Id from Response 
	 * it takes in a Response object and then parse to get an Id
	 * @param response
	 * @return
	 */
	public static String getUsersId(Response user,String UserName) {
		List<HashMap<String,String>> users = user.getBody().jsonPath().get();
		
		return getIdForTheUser(users,UserName);
	}
	
	/**
	 * This method is used to get Id from Map of all users 
	 * it takes in a List of HashMap object and then parse to get an Id
	 * @param response
	 * @return
	 */
	public static String getIdForTheUser(List<HashMap<String,String>> users,String userName) {
		Map<String,String> userNameIDStore = new HashMap<String,String>();
		for(HashMap<String,String> user:users) {
			String id = String.valueOf(user.get("id"));
			userNameIDStore.put(user.get("username"),id );
		}
		return userNameIDStore.get(userName);
		
	}

}
