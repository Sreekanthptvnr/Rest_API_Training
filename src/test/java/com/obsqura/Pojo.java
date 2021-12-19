package com.obsqura;

import org.testng.annotations.Test;

import Pojo.Root;
import api.ApiHelper;
import api.F1_Response;
import api.F1_request;
import processors.PojoProcessor;


public class Pojo {
	@Test
	public void tc01Pojo2Json() {
    F1_request req = new F1_request("https://reqres.in","Sample.json");
    F1_Response resp =ApiHelper.hitAPI(req);
	String getRespBody =resp.getResponsebody();
	System.out.println(getRespBody);
	Root root=(Root)PojoProcessor.convertJsonToDTO(getRespBody, Root.class);
	System.out.println(root.getId());
	
	System.out.println(root.getCreatedAt());
//	int getRespCode =resp.getResponsecode();
//	System.out.println(getRespCode);
//	Assert.assertEquals(getRespCode, 201);
}


}
