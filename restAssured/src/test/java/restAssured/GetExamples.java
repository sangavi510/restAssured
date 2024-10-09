package restAssured;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

import org.hamcrest.collection.HasItemInArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetExamples {

	@Test
	public void test1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		response.then().assertThat().body("data.id", hasItems(7));
		response.then().assertThat().body("data[0].email", equalTo("michael.lawson@reqres.in"));
		System.out.println(response.statusCode());
		System.out.println(response.time());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());
		System.out.println(response.getHeader("content-type"));
		Assert.assertEquals(response.statusCode(),200);
		

	}
	
	@Test
	public void test2() {
		
		baseURI = ("https://reqres.in/api");
		given().
		when().
			get("/users?page=2").
		then().
			body("data.email", hasItems("tobias.funke@reqres.in","lindsay.ferguson@reqres.in")).
			body("data[0].id", equalTo(7)).
			log().
			all();
	}	

}
