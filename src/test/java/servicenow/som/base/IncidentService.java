package servicenow.som.base;

import java.util.Map;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class IncidentService extends ServiceNow {		
	
	public void createNewRecord(Object requestBody) {
//		response = given()		
//		.contentType(ContentType.JSON)
//		.log().all()
//		.when()
//		.body(requestBody)
//		.post("/{tableName}", service_name);
		
		setResponse(base.post("/{tableName}", requestBody));
		
	}
	
	public void createNewRecord(Map<String, String> headers, Object requestBody) {
//		response = given()		
//		.headers(headers)
//		.log().all()
//		.when()
//		.body(requestBody)
//		.post("/{tableName}", service_name);
		setResponse(base.post("/tableName", requestBody));
	}
	
	public void retreiveRecord(String sysID) {
//		response = given()
//				  .log().all()
//				  .when()
//				  .get("/{tableName}/{sysId}", service_name, sysID);
		setResponse(base.get("/{tableName}/"+sysID));
	}
	
	public void retreiveRecords() {
//		response = given()
//				  .log().all()
//				  .when()
//				  .get("/{tableName}", service_name);
		setResponse(base.get("/{tableName}"));
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
		
		MatcherAssert.assertThat(getResponse().getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(getResponse().getStatusMesssage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(getResponse().getContentType(), Matchers.equalTo("application/json"));		
		
	}
	
	public void validateSuccessXmlResponse(int statusCode, String statusMessage) {
//		response.then()
//		        .assertThat()
//		        .statusCode(statusCode)
//		        .statusLine(Matchers.containsString(statusMessage))
//		        .contentType(ContentType.XML);
		MatcherAssert.assertThat(getResponse().getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(getResponse().getStatusMesssage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(getResponse().getContentType(), Matchers.equalTo("application/xml"));
	}

}