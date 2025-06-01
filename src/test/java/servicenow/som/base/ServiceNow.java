package servicenow.som.base;

import java.util.Map;

import design.IResponse;
import restassured.base.ReqSpecKeys;
import restassured.base.RestAssuredClient;

public class ServiceNow {

	RestAssuredClient base = new RestAssuredClient();
	private IResponse response;

	public void setBaseUri(String uri) {
		base.specs.put(ReqSpecKeys.BASEURI, uri);
	}

	public void setBasePath(String path) {
		base.specs.put(ReqSpecKeys.BASEPATH, path);
	}

	public void setBasicAuth(String userName, String password) {
		base.specs.put(ReqSpecKeys.BASICAUTH, userName+":"+password);		
	}
	
	public void setHeaders(Map<String, String> headers) {
		base.specs.put(ReqSpecKeys.HEADERS, headers);
	}
	
	public void setPathParams(Map<String, String> pathParams) {
		base.specs.put(ReqSpecKeys.PATHPARAMS, pathParams);
	}
	
	public void setQueryParams(Map<String, String> queryParams) {
		base.specs.put(ReqSpecKeys.QUERYPARAMS, queryParams);
	}

	public IResponse getResponse() {
		return response;
	}

	public void setResponse(IResponse response) {
		this.response = response;
	}

}