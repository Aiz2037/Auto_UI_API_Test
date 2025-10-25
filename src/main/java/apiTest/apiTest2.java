package apiTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class apiTest2 {

	// post comment using external JsonBody file
	@Test
	public void postComment() throws FileNotFoundException {
		File jsonFile = new File(".\\body.json");
		FileReader fr = new FileReader(jsonFile);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);

		Response res = given()
						.contentType("application/json")
						.body(data.toString())
						.when()
							.post("https://jsonplaceholder.typicode.com/comments");
		
		String postAPIres = res.getBody().jsonPath().get().toString();
		System.out.println(postAPIres);
		
		String id = (res.getBody().jsonPath().get("id")).toString();
		Assert.assertEquals(id, "501");
		/*
		 * .then() .statusCode(201) .log().body();
		 */
	}
}
