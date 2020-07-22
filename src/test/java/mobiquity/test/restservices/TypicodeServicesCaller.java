package mobiquity.test.restservices;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import mobiquity.test.requestmappings.RequestsMappings;
import mobiquity.test.requests.model.RequestParameters;

public class TypicodeServicesCaller {

	public TypicodeServicesCaller() {
		this.RequestsMappings = new RequestsMappings();
		this.requestParameters = new RequestParameters();
		this.headers = new HashMap<String,String>();

	}

	RequestsMappings RequestsMappings;
	RequestParameters requestParameters;
	Map<String, String> headers;

	
	public Response getUsers() {

		requestParameters.setRequestMapping("/users");

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response getUsersComment(String userId) {

		requestParameters.setRequestMapping("/posts/" + userId + "/comments");

		return RequestsMappings.getRequestsResponse(requestParameters);

	}

	public Response getUsersPhotos(String userId) {

		requestParameters.setRequestMapping("/posts/" + userId + "/photos");

		return RequestsMappings.getRequestsResponse(requestParameters);

	}
	public Response getUsersAlbums(String userId) {

		requestParameters.setRequestMapping("/posts/" + userId + "/albums");

		return RequestsMappings.getRequestsResponse(requestParameters);

	}
	public Response getUsersTodos(String userId) {

		requestParameters.setRequestMapping("/posts/" + userId + "/todos");

		return RequestsMappings.getRequestsResponse(requestParameters);

	}
	public Response getUsersPosts(String userId) {

		requestParameters.setRequestMapping("/posts/" + userId + "/posts");

		return RequestsMappings.getRequestsResponse(requestParameters);

	}
}
