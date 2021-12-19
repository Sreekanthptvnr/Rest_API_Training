package com.obsqura;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.ApiHelper;
import api.F1_Response;
import api.F1_request;

public class CreateSingleUser {

	@Test
	public void tc01CreateUserReafFromJson() {
		
//		HashMap<String,String>apiData= new HashMap<String,String>();
//		apiData.put("name", "a");
//		apiData.put("job", "b");
	    F1_request req = new F1_request("https://reqres.in","Sample.json");
	    F1_Response resp = ApiHelper.hitAPI(req);
		String rspBody =resp.getResponsebody();
		System.out.println(rspBody);
		int respCode =resp.getResponsecode();
		System.out.println(respCode);
		Assert.assertEquals(respCode, 201);
		
	}
	
	
		
		
	}

