package restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemeValidator {
	@Test
		public void get() {
			baseURI="https://reqres.in/api";
			
			given().
				get("/users?page=2").
			then().
			assertThat().body(matchesJsonSchemaInClasspath("src/main/resources/schema.json")).
				statusCode(200).
				log().all();
		}
}
