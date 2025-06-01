package restassured.base;

import design.IRequest;
import design.IResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static restassured.base.ReqSpecKeys.*;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAssuredClient implements IRequest {
	
	private Response response;
	public Map<String, Object> specs = new HashMap<String, Object>();
		
	private RequestSpecification request() {
		return given().spec(preCondtions().build()).log().all().when();
	}

	@Override
	public IResponse get(String endPoint) {	
		response = request().get(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse post(String endPoint, Object requestBody) {
		response = request().body(requestBody).post(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse put(String endPoint, Object requestBody) {
		response = request().body(requestBody).put(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse patch(String endPoint, Object requestBody) {
		response = request().body(requestBody).patch(endPoint);
		return new RestAssuredResponse(response);
	}

	@Override
	public IResponse delete(String endPoint) {
		response = request().delete(endPoint);
		return new RestAssuredResponse(response);
	}
	
	public RequestSpecBuilder preCondtions() {

		RequestSpecBuilder builder = new RequestSpecBuilder();

		if (specs.get(BASEURI) != null) {
			builder.setBaseUri(specs.get(BASEURI).toString());
		}

		if (specs.get(BASEPATH) != null) {
			builder.setBasePath(specs.get(BASEPATH).toString());
		}

		if (specs.get(BASICAUTH) != null) {
			String[] strings = specs.get(BASICAUTH).toString().split(":");
			builder.setAuth(basic(strings[0], strings[1]));
		}

		if (specs.get(HEADERS) != null) {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> map = mapper.convertValue(specs.get(HEADERS),
					new TypeReference<Map<String, String>>() {
					});
			builder.addHeaders(map);
		}

		if (specs.get(PATHPARAMS) != null) {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> map = mapper.convertValue(specs.get(PATHPARAMS),
					new TypeReference<Map<String, String>>() {
					});
			builder.addPathParams(map);
		}

		if (specs.get(QUERYPARAMS) != null) {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> map = mapper.convertValue(specs.get(QUERYPARAMS),
					new TypeReference<Map<String, String>>() {
					});
			builder.addQueryParams(map);
		}

		return builder;
	}

}