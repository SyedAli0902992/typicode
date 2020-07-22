package mobiquity.test.testsuite;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import io.restassured.response.Response;
import mobiquity.test.helper.ReadJsonHelper;
import mobiquity.test.helper.ResponseValidatorHelper;
import mobiquity.test.restservices.TypicodeServicesCaller;
import mobiquity.test.validators.ResponseValidator;

public class MobiquityTest {

	TypicodeServicesCaller typicodeServicesCaller;
	JSONObject testcaseData;

	@Before
	public void init() {
		this.typicodeServicesCaller = new TypicodeServicesCaller();
		this.testcaseData = ReadJsonHelper.getParsedJsonAsString("TestData");
	}

	/*
	 * This test is validate if get users call is success and 
	 * all the emails retrieved for the user is valid
	 */
	@Test
	public void testValidEmails() {
		@SuppressWarnings("unchecked")
		Map<String, String> testCase_1_Data = (Map<String, String>) testcaseData.get("TestCase -1");
		Response users = typicodeServicesCaller.getUsers();
		assertTrue(ResponseValidator.validateUserNameIsUnique(users));
		// validate api request was succesful
		assertTrue(ResponseValidator.validateStatusCode(users, 200));

		String userId = ResponseValidatorHelper.getUsersId(users, testCase_1_Data.get("username"));

		Response response = typicodeServicesCaller.getUsersComment(userId);
		assertTrue(ResponseValidator.validateStatusCode(users, 200));

		// validate if all the emails are in right format
		assertTrue(ResponseValidator.validateValidEmail(response));

	}

	/*
	 * This test is validate if get posts title and body and validate if its correct
	 * 
	 */
	@Test
	public void testValidateTitleBodyOfaPost() {
		@SuppressWarnings("unchecked")
		Map<String, String> testCase_2_Data = (Map<String, String>) testcaseData.get("TestCase -2");

		Response users = typicodeServicesCaller.getUsers();
		assertTrue(ResponseValidator.validateStatusCode(users, 200));

		String userId = ResponseValidatorHelper.getUsersId(users, testCase_2_Data.get("username"));
		Response post = typicodeServicesCaller.getUsersPosts(userId);
		assertTrue(ResponseValidator.validateStatusCode(post, 200));
		assertTrue(ResponseValidator.validateTitleAndBody(post, testCase_2_Data.get("title"),
				testCase_2_Data.get("body")));
		// validate api request was succesful

	}
}
