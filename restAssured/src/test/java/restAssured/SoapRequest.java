package restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;

public class SoapRequest {
	@Test
	public void post() throws IOException {
		File file = new File("./soapRequest/soapRequest.xml");
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = org.apache.commons.io.IOUtils.toString(fileInputStream, "UTF-8");
		baseURI = "https://www.crcind.com:443/csp/samples/SOAP.Demo.cls";
		if (file.exists()){
			  System.out.println("  > >  File exists");
			 }

			given().
			 contentType("text/xml").
			 accept(ContentType.XML).
			 body(requestBody).

			when().post("/SOAP.Demo.cls").

			then()
			.log().all();
	}

}
