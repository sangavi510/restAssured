package restAssured;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

import org.hamcrest.collection.HasItemInArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetExamples {

	@Test(enabled=true)
	public void test1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		ResponseBody body = response.getBody();
		String bodyAsString = body.asString();
		JsonPath js = JsonPath.from(bodyAsString) ;
		System.out.println("Email :" +js.get("id"));
		response.then().assertThat().body("data.id", hasItems(7));
		response.then().assertThat().body("data[0].email", equalTo("michael.lawson@reqres.in"));
		System.out.println(response.statusCode());
		System.out.println(response.time());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());
		Assert.assertEquals(response.getHeader("content-type"),"application/json; charset=utf-8");
		Assert.assertEquals(response.getHeader("server"),"cloudflare");
		Assert.assertEquals(response.getHeader("Content-Encoding"),"gzip");
		Assert.assertEquals(response.statusCode(),200);
		
		

	}
	
	@Test(enabled=false)
	public void test2() {
		
		baseURI = ("https://reqres.in/api");
		given().
		//auth().basic("user", "pass").
		auth().basic("user", "pass").
		when().
			get("/users?page=2").
		then().
			body("data.email", hasItems("tobias.funke@reqres.in","lindsay.ferguson@reqres.in")).
			body("data[0].id", equalTo(7)).
			header("Content-Type","application/json" ).
			log().
			all();
	}	

}
