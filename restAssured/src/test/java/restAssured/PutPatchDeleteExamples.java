package restAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

	@Test
	public void putTest() {

		JSONObject res =new JSONObject();
		res.put("name", "Sangavi");
		res.put("job", "QA Analyst");

		System.out.println(res.toJSONString());

		baseURI = "https://reqres.in";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(res.toJSONString()).
		when().
		put("/api/users/2").
		then().
		statusCode(200).
		log().
		all();
	}

	public class PatchExamples {

		@Test
		public void patchTest() {

			JSONObject res =new JSONObject();
			res.put("name", "Sangavi");
			res.put("job", "QA Analyst");

			System.out.println(res.toJSONString());

			baseURI = "https://reqres.in";

			given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(res.toJSONString()).
			when().
			patch("/api/users/2").
			then().
			statusCode(200).
			log().
			all();
		}
	}
	public class DeleteExamples {

		@Test
		public void deleteTest() {

			baseURI = "https://reqres.in";
			when().
			delete("/api/users/2").
			then().
			statusCode(204).
			log().
			all();
		}
	}
	}

