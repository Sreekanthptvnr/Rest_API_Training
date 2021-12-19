package com.obsqura;

import org.junit.Assert;
import org.testng.annotations.Test;

import api.ApiHelper;
import api.F1_Response;
import api.F1_request;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserRequest {
	@Test
	public void tc01GetUser() {
		RestAssured.baseURI="https://reqres.in";//base url
		RequestSpecification httpRequest=RestAssured.given();
		Response response =httpRequest.request(Method.GET,"/api/users/2");//url param or resource url
		String resp =response.getBody().asString();
		System.out.println(resp);
		int respCode =response.getStatusCode();
		System.out.println(respCode);
		Headers headers= response.getHeaders();
		String getHeaders =headers.getValue("connection");
		System.out.println(getHeaders);
		Assert.assertEquals(200, respCode);
	}

}
