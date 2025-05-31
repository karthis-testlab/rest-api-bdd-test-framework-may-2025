package restassured.base;

import design.IRequest;
import design.IResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RestAssuredClient implements IRequest {
	
	private Response response;	
	
	private RequestSpecification request() {
		return given().log().all().when();
	}

	@Override
	public IResponse get(String endPoint) {	
		response = request().get(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse post(String endPoint, Object requestBody) {
		response = request().contentType(ContentType.JSON).body(requestBody).post(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse put(String endPoint, Object requestBody) {
		response = request().contentType(ContentType.JSON).body(requestBody).put(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse patch(String endPoint, Object requestBody) {
		response = request().contentType(ContentType.JSON).body(requestBody).patch(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse delete(String endPoint) {
		response = request().delete(endPoint);
		return new RestAssuredResponse(response);
	}

}