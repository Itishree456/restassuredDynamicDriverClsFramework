package commonFunctionsPack;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class API_Common_Function {

	public static int Response_statusCode(String BaseURI, String RequestBody, String Resource) {

		// Step 1: Declare Base URL
		RestAssured.baseURI = BaseURI;

		// Step 2: Configure Response Body
		int statusCode = given().header("Content-Type", "application/json").body(RequestBody).when().post(Resource)
				.then().extract().statusCode();

		return statusCode;

	}

	public static String Response_body(String BaseURI, String RequestBody, String Resource) {

		// Step 1: Declare Base URL
		RestAssured.baseURI = BaseURI;

		// Step 2: Configure Response Body
		String responseBody = given().header("Content-Type", "application/json").body(RequestBody).when().post(Resource)
				.then().extract().response().asString();

		return responseBody;

	}

}