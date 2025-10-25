package apiTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class apiTest1 {
	
	@Test
	public void testCommentResponse() {
		Response res = given()
			.contentType("ContentType.JSON")
		.when()
			.get("https://jsonplaceholder.typicode.com/comments");
		/*.then()
			.statusCode(200)
			//.header("Content-Type", "application/json; charset=utf-8")
			//use https://jsonpathfinder.com/
			.body("[2].name", equalTo("odio adipisci rerum aut animi"))
			.body("[2].email", equalTo("Nikita@garfield.biz"));*/
		
		String name = res.jsonPath().get("[2].name").toString();
		Assert.assertEquals(name, "odio adipisci rerum aut animi");
		
		String email = res.jsonPath().get("[2].email").toString();
		Assert.assertEquals(email, "Nikita@garfield.biz");
	}
}
