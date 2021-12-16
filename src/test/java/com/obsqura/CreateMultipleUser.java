package com.obsqura;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.ApiHelper;
import api.F1Request;
import api.F1_Response;
import api.F1_request;

public class CreateMultipleUser {
	
	@Test
	public void test1() {
		HashMap<String,String>apidata= new HashMap<String,String>();
		apidata.put("name", "ABC");
		apidata.put("job", "doctor");
	    F1_request req = new F1_request("https://reqres.in","Sample.json",apidata);
	    F1_Response resp =ApiHelper.hitAPI(req);
		String rspBody =resp.getResponsebody();
		System.out.println(rspBody);
		int respCode =resp.getResponsecode();
		System.out.println(respCode);
		Assert.assertEquals(respCode, 201);
	}
	
	
	}


