package testClassPack;

import java.io.IOException;
import org.testng.Assert;
import commonFunctionsPack.API_Common_Function;
import commonFunctionsPack.Utility_Common_Function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPack.Post_req_repository;
import testClassPack.Post_TC_1;

public class Post_TC_1 {

	public static void execute() throws IOException {

		for (int i = 0; i < 5; i++) {
			int statusCode = API_Common_Function.Response_statusCode(Post_req_repository.Base_URI(),
					Post_req_repository.Post_TC1(), Post_req_repository.Post_Resource());

			if (statusCode == 201) {
				String responseBody = API_Common_Function.Response_body(Post_req_repository.Base_URI(),
						Post_req_repository.Post_TC1(), Post_req_repository.Post_Resource());
				Post_TC_1.validator(responseBody, statusCode);
				Utility_Common_Function.Evidence_File_Creator("Post_TC_1", Post_req_repository.Post_TC1(),
						responseBody);
				break;

			} else {
				System.out.println("Correct StatusCode is not found. Hence retrying the API ");
			}

		}
	}

	public static void validator(String responseBody, int statusCode) throws IOException {

		// Step 4: Parse the response body
		JsonPath jsp = new JsonPath(responseBody);
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_id = jsp.getString("id");
		String res_createdAt = jsp.getString("createdAt");

		// Step 5: Parse request body and it's parameters
		JsonPath jspreq = new JsonPath(Post_req_repository.Post_TC1());
		String req_name = jspreq.getString("name");
		String req_job = jspreq.getString("job");

		// Step 6: Validate the response body parameters
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);

		// Validate "id" and "createdAt" using Assert
		Assert.assertNotNull(res_id);
		Assert.assertNotNull(res_createdAt);

		// Validate "createdAt" using slice method for date
		String expectedDate = new java.util.Date().toInstant().toString().substring(0, 10);
		String actualDate = res_createdAt.substring(0, 10);
		Assert.assertEquals(actualDate, expectedDate);

		System.out.println("Status code is: " + statusCode + " Created");
		System.out.println(responseBody);

	}

}