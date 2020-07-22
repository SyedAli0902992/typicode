package mobiquity.test.validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import io.restassured.response.Response;

public class ResponseValidator {

	public static boolean validateValidEmail(Response response) {
		boolean emailValidation = true;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		List<String> email = response.getBody().jsonPath().get("email");
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		for (String emails : email) {
			if (!pat.matcher(emails).matches()) {
				emailValidation = false;
			}
		}

		return emailValidation;

	}
	
	
	public static boolean validateUserNameIsUnique(Response response) {
		boolean userExsistsValidation = true;
		Map<String,Integer> userNameMap = new HashMap<String,Integer>();

		List<String> userNames = response.getBody().jsonPath().get("username");
		if (userNames == null)
			return false;
		for (String userName : userNames) {
			if (userNameMap.containsKey(userName)) {
				userExsistsValidation = false;
			}
		}

		return userExsistsValidation;

	}
	
	public static boolean validateTitleAndBody(Response user,String title,String body) {
		boolean titleAndBodyValidation = true;
		List<HashMap<String,String>> posts = user.getBody().jsonPath().get();
		for(HashMap<String,String> post:posts) {
			if (post.get("title").equals(title)) {
				if (!post.get("body").equals(body)) {
					titleAndBodyValidation = false;
				}
			}
		}
		return titleAndBodyValidation;
	}

	public static boolean validateStatusCode(Response response, int expectedStatusCode) {
		int statusCode = response.getStatusCode();

		return (statusCode == expectedStatusCode);
	}

	public static boolean validateResponseSize(Response response, int expectedSize) {

		List<?> responseBody = response.getBody().jsonPath().get("");

		return responseBody.size() == expectedSize;

	}

}
