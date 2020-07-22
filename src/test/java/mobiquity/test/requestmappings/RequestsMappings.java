package mobiquity.test.requestmappings;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import mobiquity.test.constants.Constants;
import mobiquity.test.helper.RequestMappingHelper;
import mobiquity.test.requests.model.RequestParameters;

public class RequestsMappings {

	{
	RestAssured.baseURI = Constants.BASE_URI;
	}
	
	/**
	 * This method forms the response for get request mappings
	 * @param requestParameters
	 * @return
	 */
	public Response getRequestsResponse(RequestParameters requestParameters) {
		;
		if(!(RequestMappingHelper.createGiven(requestParameters)==null)) {
			return
			RequestMappingHelper.createGiven(requestParameters).
			 when().get(requestParameters.getRequestMapping());
		}else {
			return
					given().get(requestParameters.getRequestMapping());
		
		}
		
		
		
	}
	
	/**
	 * This method forms the response for Post request mappings
	 * @param requestParameters
	 * @return
	 */
    public Response postRequestsResponse(RequestParameters requestParameters) {
       
    	return
				RequestMappingHelper.createGiven(requestParameters).
				when().post(requestParameters.getRequestMapping());
	}
    
    /**
	 * This method forms the response for delete request mappings
	 * @param requestParameters
	 * @return
	 */
    public Response deleteRequestsResponse(RequestParameters requestParameters) {
    	
    	return
    			RequestMappingHelper.createGiven(requestParameters).
    			when().delete(requestParameters.getRequestMapping());
		
	}
    
    /**
	 * This method forms the response for patch request mappings
	 * @param requestParameters
	 * @return
	 */
   public Response patchRequestsResponse(RequestParameters requestParameters) {
    	
    	return
    			RequestMappingHelper.createGiven(requestParameters).
    			when().patch(requestParameters.getRequestMapping());
		
	}
   
   /**
	 * This method forms the response for put request mappings
	 * @param requestParameters
	 * @return
	 */
  public Response putRequestsResponse(RequestParameters requestParameters) {
   	
   	return
   			RequestMappingHelper.createGiven(requestParameters).
   			when().put(requestParameters.getRequestMapping());
		
	}

}
