package com.obsqura;

import java.util.HashMap;

import api.ApiHelper;
import api.F1_Response;
import api.F1_request;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateMultipleUser {
	
	 @Test (dataProvider = "data-provider")
	public void test1(String a,String b) {
		HashMap<String,String>apiData= new HashMap<String,String>();
		apiData.put("name", "a");
		apiData.put("job", "b");
	    F1_request req = new F1_request("https://reqres.in","Sample.json",apiData);
	    F1_Response resp = ApiHelper.hitAPI(req);
		String rspBody =resp.getResponsebody();
		System.out.println(rspBody);
		int respCode =resp.getResponsecode();
		System.out.println(respCode);
		Assert.assertEquals(respCode, 201);
	}
	@DataProvider (name = "data-provider")

	public  Object[][] dp(){
		
		return  new Object[][] {{"john","engineer"}, {"joy","doctor"}};
	}

	
	}


