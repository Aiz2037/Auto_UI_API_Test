package apiTest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class apiTest3 {
	@Test
	public void testUserResponse() {
		Response res = given()
			.contentType("ContentType.JSON")
		.when()
			.get("https://jsonplaceholder.typicode.com/users");
		
		//https://jsonpathfinder.com/
		String street = res.jsonPath().get("[5].address.street").toString();
		Assert.assertEquals(street, "Norberto Crossing");
		
		String city = res.jsonPath().get("[5].address.city").toString();
		Assert.assertEquals(city, "South Christy");
	}
}
