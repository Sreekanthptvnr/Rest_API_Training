package com.obsqura;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.ApiHelper;
import api.F1_Response;
import api.F1_request;

public class GetReqCoWin {
	@Test
	public void tc01GetAppointments() {
		F1_request cowinReq = new F1_request("https://cdn-api.co-vin.in",
				"/api/v2/appointment/sessions/public/calendarByDistrict?district_id=302&date=09-12-2021", "GET");
		F1_Response resp = ApiHelper.hitAPI(cowinReq);
		String respBody = resp.getResponsebody();
		System.out.println(respBody);
		int respCode = resp.getResponsecode();
		System.out.println(respCode);
		Assert.assertEquals(respCode, 200);
	}
}
