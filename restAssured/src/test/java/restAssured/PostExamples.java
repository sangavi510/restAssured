package restAssured;
import static io.restassured.RestAssured.*;
import org.json.simple.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class PostExamples {
	
	@Test
	public void postTest() {
		
	/*Map<String, Object> map = new HashMap<String,Object>();
	map.put("id", 15);
	map.put("email", "sangavi510@gmail.com");
	map.put("first_name", "Sangavi");
	
	System.out.println(map);*/
	
	JSONObject res =new JSONObject();
	res.put("id", 15);
	res.put("email", "sangavi510@gmail.com");
	res.put("first_name", "Sangavi");
	
	System.out.println(res.toJSONString());

	baseURI = "https://reqres.in/api";
	
	given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(res.toJSONString()).
	when().
		post("/users").
	then().
		statusCode(201).
		log().
		all();
}
}
