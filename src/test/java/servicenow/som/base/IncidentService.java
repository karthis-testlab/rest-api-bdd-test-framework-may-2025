package servicenow.som.base;

import java.util.Map;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import design.IResponse;
import restassured.base.RestAssuredClient;

public class IncidentService {
	
	private static final String service_name = "incident";
	RestAssuredClient base = new RestAssuredClient();
	private IResponse response;
	
	public void createNewRecord(Object requestBody) {
//		response = given()		
//		.contentType(ContentType.JSON)
//		.log().all()
//		.when()
//		.body(requestBody)
//		.post("/{tableName}", service_name);
		
		response = base.post("/"+service_name, requestBody);
		
	}
	
	public void createNewRecord(Map<String, String> headers, Object requestBody) {
//		response = given()		
//		.headers(headers)
//		.log().all()
//		.when()
//		.body(requestBody)
//		.post("/{tableName}", service_name);
		response = base.post("/"+service_name, requestBody);
	}
	
	public void retreiveRecord(String sysID) {
//		response = given()
//				  .log().all()
//				  .when()
//				  .get("/{tableName}/{sysId}", service_name, sysID);
	}
	
	public void retreiveRecords() {
//		response = given()
//				  .log().all()
//				  .when()
//				  .get("/{tableName}", service_name);
	}
	
	public void retreiveHadwareCategoryRecords() {
//		response = given()
//				  .queryParam("sysparm_query", "category=hardware")
//				  .log().all()
//				  .when()
//				  .get("/{tableName}", service_name);
	}
	
	public void validateSuccessResponse(int statusCode, String statusMessage) {
//		response.then()
//		        .assertThat()
//		        .statusCode(statusCode)
//		        .statusLine(Matchers.containsString(statusMessage))
//		        .contentType(ContentType.JSON);
		
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMesssage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));		
		
	}
	
	public void validateSuccessXmlResponse(int statusCode, String statusMessage) {
//		response.then()
//		        .assertThat()
//		        .statusCode(statusCode)
//		        .statusLine(Matchers.containsString(statusMessage))
//		        .contentType(ContentType.XML);
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMesssage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/xml"));
	}

}