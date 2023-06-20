package requestRepositoryPack;

import java.io.IOException;
import java.util.ArrayList;
import commonFunctionsPack.Utility_Common_Function;

public class Post_req_repository {

	public static String Base_URI() {

		String BaseURI = "https://reqres.in/";

		return BaseURI;

	}

	public static String Post_Resource() {

		String Resource = "api/users";

		return Resource;

	}

	public static String Post_TC1() throws IOException {

		ArrayList<String> data = Utility_Common_Function.ReadDataExcel("Post_Test_Data", "Post_TC_1");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String RequestBody = "{\r\n" + "    \"name\": \"" + req_name + "\",\r\n" + "    \"job\": \"" + req_job
				+ "\"\r\n" + "}\r\n" + "";

		return RequestBody;

	}

	public static String Post_TC2() throws IOException {

		ArrayList<String> data = Utility_Common_Function.ReadDataExcel("Post_Test_Data", "Post_TC_2");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String RequestBody = "{\r\n" + "    \"name\": \"" + req_name + "\",\r\n" + "    \"job\": \"" + req_job
				+ "\"\r\n" + "}\r\n" + "";

		return RequestBody;

	}

	public static String Post_TC3() throws IOException {

		ArrayList<String> data = Utility_Common_Function.ReadDataExcel("Post_Test_Data", "Post_TC_3");
		String req_name = data.get(1);
		String req_job = data.get(2);
		String RequestBody = "{\r\n" + "    \"name\": \"" + req_name + "\",\r\n" + "    \"job\": \"" + req_job
				+ "\"\r\n" + "}\r\n" + "";

		return RequestBody;

	}

}
