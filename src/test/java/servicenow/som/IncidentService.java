package servicenow.som;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentService {
	
	private static final String service_name = "incident";
	private Response response;
	
	public void createNewRecord(Object requestBody) {
		response = given()		
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.body(requestBody)
		.post("/{tableName}", service_name);
	}
	
	public void createNewRecord(Map<String, String> headers, Object requestBody) {
		response = given()		
		.headers(headers)
		.log().all()
		.when()
		.body(requestBody)
		.post("/{tableName}", service_name);
	}
	
	public void retreiveRecord(String sysID) {
		response = given()
				  .log().all()
				  .when()
				  .get("/{tableName}/{sysId}", service_name, sysID);
	}
	
	public void retreiveRecords() {
		response = given()
				  .log().all()
				  .when()
				  .get("/{tableName}", service_name);
	}
	
	public void retreiveHadwareCategoryRecords() {
		response = given()
				  .queryParam("sysparm_query", "category=hardware")
				  .log().all()
				  .when()
				  .get("/{tableName}", service_name);
	}
	
	public void validateSuccessResponse(int statusCode, String statusMessage) {
		response.then()
		        .assertThat()
		        .statusCode(statusCode)
		        .statusLine(Matchers.containsString(statusMessage))
		        .contentType(ContentType.JSON);
	}
	
	public void validateSuccessXmlResponse(int statusCode, String statusMessage) {
		response.then()
		        .assertThat()
		        .statusCode(statusCode)
		        .statusLine(Matchers.containsString(statusMessage))
		        .contentType(ContentType.XML);
	}

}