package servicenow.som.base;

import java.util.Map;

import restassured.base.RestAssuredClient;

public class ServiceNowBase {

	protected RestAssuredClient base = new RestAssuredClient();

	public void setBaseUri(String uri) {
		base.specs.put("baseUri", uri);
	}

	public void setBasePath(String path) {
		base.specs.put("basePath", path);
	}
	
	public void setBasicAuth(String username, String password) {
		base.specs.put("basicAuth", username+":"+password);
	}
	
	public void setHeaders(Map<String, String> headers) {
		base.specs.put("headers", headers);
	}

}