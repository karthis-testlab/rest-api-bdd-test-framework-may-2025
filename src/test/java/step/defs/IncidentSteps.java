package step.defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.IncidentRequestPayload;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;

public class IncidentSteps {
	
	IncidentRequestPayload requestPayload = new IncidentRequestPayload();
	Map<String, String> pathParamters = new HashMap<String, String>();
	Map<String, String> headers = new HashMap<String, String>();
	String requstBody;
	Response response;

	@Given("Set the base uri {string} of the service now application")
	public void set_the_base_uri_of_the_service_now_application(String uri) {
		baseURI = uri;
	}

	@Given("Set the base path {string} of the service now api")
	public void set_the_base_path_of_the_service_now_api(String path) {
		basePath = path;
	}

	@Given("Set the path parameter key name as {string} and value as {string}")
	public void set_the_path_parameter_key_name_as_and_value_as(String key, String value) {
		pathParamters.put(key, value);
	}

	@Given("Set basic authentication with username {string} and password {string}")
	public void set_basic_authentication_with_username_and_password(String username, String password) {
		authentication = basic(username, password);
	}

	@Given("Add the header with key name as {string} and value as {string}")
	public void add_the_header_with_key_name_as_and_value_as(String key, String value) {
		headers.put(key, value);
	}

	@When("send the request body as form of string value {string}")
	public void send_the_request_body_as_form_of_string_value(String string) {
		requstBody = string;
	}

	@When("hit the post method to create new record")
	public void hit_the_post_method_to_create_new_record() {
		response = given()
		.pathParams(pathParamters)
		.headers(headers)
		.log().all()
		.when()
		.body(requstBody)
		.post("/{tableName}");
	}

	@Then("validate the record is created succesfully")
	public void validate_the_record_is_created_succesfully() {
		response
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.statusLine(Matchers.containsString("Created"));
	}
	
	@When("send the request body as a POJO object")
	public void send_the_request_body_as_a_pojo_object(DataTable dataTable) {
		List<List<String>> asLists = dataTable.asLists();
		for (int i = 0; i < asLists.size(); i++) {
			requestPayload.setShort_description(asLists.get(i).get(0));
			requestPayload.setDescription(asLists.get(i).get(1));
		}
	}
	
	@When("hit the post method to create new record the body is POJO object")
	public void hit_the_post_method_to_create_new_record_the_body_is_pojo_object() {
		response = given()
				.pathParams(pathParamters)
				.headers(headers)
				.log().all()
				.when()
				.body(requestPayload)
				.post("/{tableName}");
	}

}