package restassured.base;

import design.IResponse;
import io.restassured.response.Response;

public class RestAssuredResponse implements IResponse {
	
	private Response response;
	
	public RestAssuredResponse(Response response) {
		this.response = response;
	}

	@Override
	public int getStatusCode() {		
		return response.getStatusCode();
	}

	@Override
	public String getStatusMesssage() {	
		String[] strings = response.getStatusLine().split(" ", 3);
		return strings[strings.length - 1];                                      
	}                                                         

	@Override
	public String getContentType() {		
		String[] strings = response.getContentType().split(";");		
		return strings[0];
	}

	@Override
	public String getResponseBody() {		
		return response.asPrettyString();
	}	

}