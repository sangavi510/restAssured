package restAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class LocalHost {
	@Test(enabled=false)
	public void get() {
		baseURI="http://localhost:3000";
		
		given().
		when().
			get("/users").
		then().
			body("DOB[1]",equalTo("29/07/1978")).
			statusCode(200).
			log().all();
	}
	@Test(enabled=false)
	public void post() {
		
		JSONObject obj = new JSONObject();
		obj.put("firstname", "Samyukth");
		obj.put("lastname", "Sakthivel");
		obj.put("DOB", "10/07/2023");
		obj.put("id", "22");
		obj.put("subjectId", "2");
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	@Test(enabled=false)
public void put() {
		
		JSONObject obj = new JSONObject();
		obj.put("firstname", "Samyukthas");
		obj.put("lastname", "Yamini");
		
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			put("/users/22").
		then().
			statusCode(200).
			log().all();
	}
	@Test
public void patch() {
		
		JSONObject obj = new JSONObject();
		obj.put("firstname", "Sanguuu");
		obj.put("lastname", "Karpagame");
		
		
		baseURI="http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			patch("/users/5").
		then().
			statusCode(200).
			log().all();
	}
	@Test(enabled=true)
	public void delete() {
baseURI="http://localhost:3000";
		
		given().
		when().
			delete("/users/lCeCUOV").
		then().
			statusCode(200).
			log().all();
	}
}
