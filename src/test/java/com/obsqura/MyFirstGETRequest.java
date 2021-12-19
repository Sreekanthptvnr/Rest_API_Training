package com.obsqura;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.Root;
import api.ApiHelper;
import api.F1_Response;
import api.F1_request;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import processors.PojoProcessor;

public class MyFirstGETRequest {
	@Test(enabled=false)
	public void test1() {
		//PreRequisites to hit API-Endpoint,Headers
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


	}
	@Test(enabled=false)
	public void test2() {
		//PreRequisites to hit API-Endpoint,Headers
		RestAssured.baseURI="https://reqres.in";//base url
		RequestSpecification httpRequest=RestAssured.given();
		Response response =httpRequest.request(Method.GET,"/api/users?page=2");//url param or resource url
		String resp =response.getBody().asString();
		System.out.println(resp);
		int respCode =response.getStatusCode();
		System.out.println(respCode);
		Headers headers= response.getHeaders();
		String respHeaders =headers.getValue("connection");
		System.out.println(respHeaders);


	}
	@Test(enabled=false)
	public void test3() {
		//Response h =Apihelper.hitAPI();
		//System.out.println(h);
	}
	
	@Test(enabled=false)
	public void test4() {
		F1_request req =new F1_request("https://reqres.in","/api/users/2","GET");
		//Response h =Apihelper.hitAPI(req);
		//String k =h.getBody().asString();
		//System.out.println(k);
	}
	@Test(enabled=false)
	public void test5() {
		F1_request req =new F1_request("https://reqres.in","/api/users/2","GET");
		F1_Response resp =ApiHelper.hitAPI(req);
		String getResp =resp.getResponsebody();
		System.out.println(getResp);
		int getRespCode =resp.getResponsecode();
		System.out.println(getRespCode);
		Assert.assertEquals(getRespCode, 200);
	}
	@Test(enabled=false)
	public void test6() {
		String requestbody= " {\r\n" + 
				"    \"name\": \"sreekanth\",\r\n" + 
				"    \"job\": \"doctor\"\r\n" + 
				"}";
//	    HashMap<String,String>header=new HashMap<String,String>();
//	    header.put("Connection", "keep-alive");
		F1_request req =new F1_request("https://reqres.in","/api/users","POST",requestbody,header);
		F1_Response h =ApiHelper.hitAPI(req);
		String k =h.getResponsebody();
		System.out.println(k);
		int j =h.getResponsecode();
		System.out.println(j);
		Assert.assertEquals(j, 201);
	}
	@Test
	public void test7() {
		
	    F1_request req = new F1_request("https://reqres.in","Sample.json");
	    F1_Response resp =ApiHelper.hitAPI(req);
		String getRespBody =resp.getResponsebody();
//		System.out.println(getRespBody);
		Root root=(Root)PojoProcessor.convertJsonToDTO(getRespBody, Root.class);
		System.out.println(root.getId());
//		int getRespCode =resp.getResponsecode();
//		System.out.println(getRespCode);
//		Assert.assertEquals(getRespCode, 201);
	}
	
	
	}
	
	

