package com.util.post;


<<<<<<< HEAD:basic-util/src/com/post/PostTest.java
import java.util.ArrayList;
import java.util.HashMap;

=======
>>>>>>> 3ac7d94f32c693f3d2491c8d2aa9300742f5d5a9:basic-util/src/com/util/post/PostTest.java
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.junit.Test;
<<<<<<< HEAD:basic-util/src/com/post/PostTest.java
=======

import java.util.ArrayList;
import java.util.HashMap;
>>>>>>> 3ac7d94f32c693f3d2491c8d2aa9300742f5d5a9:basic-util/src/com/util/post/PostTest.java

public class PostTest {
	 private static Logger logger = Logger.getLogger(PostTest.class);

	@Test
		public void idCardTest(){
			
			String retJson ="";
			String url = "http://10.255.10.82:9960/index.php/service/idcardservice/getIdcardInfo";
			String formStr = "appid=asdfasdfasfasdfadsf&cert_img_code_back=i4u2tr3mjfv4dilip1ihudq7gwpg6mv2&cert_img_code_front=nlki3blwrsjp4u6wdq86tm4nwpkp1j45&cert_img_key_back=123&cert_img_key_front=123&nonce_str=nFeoyMG8EJauSCUTdxHIbAfSGdhGHFgf&sign=27CF314FDDCEF39DDA8DE80EB8A080A3&sign_type=MD5";
		    try {
		    	retJson = PostJsonRequest.PostForm(url, formStr);
				System.out.println(retJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
			
		}
	 
	@Test
	public void cgiRequestTest(){
		
		String retJson ="";
		String url = "localhost:9923/cgiproxy/cgiRequest";
		JSONObject jsonObj = new JSONObject();
     	jsonObj.element("case_id", "123456");
      	jsonObj.element("plan_result_id", "2345677");
      	jsonObj.element("dcn", "A00:R-DCN | A10:R-DCN | A70:C-DCN | AA0:ADM-DCN");
	    jsonObj.element("days", "+0D");
	    try {
	    	retJson = PostJsonRequest.PostJson(url, jsonObj);
			System.out.println(retJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		
	}
	@Test
	public void batchRequestTest(){
		String retJson ="";
		String url = "http://localhost:9926/batchproxy/queryService";
		JSONObject jsonObj = new JSONObject();
     	jsonObj.element("case_id", "123456");
      	jsonObj.element("plan_result_id", "2345677");
      	jsonObj.element("dcn", "A00:R-DCN | A10:R-DCN | A70:C-DCN | AA0:ADM-DCN");
	    jsonObj.element("days", "+0D");
	    try {
//	    	retJson = PostJsonRequest.PostJsonRequest(url, jsonObj);
	    	JSONObject ret2 = HttpRequestUtils.httpPost(url, jsonObj);
			System.out.println(ret2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		
	}
	
	
	@Test
	public void idcardTest_php(){
//		String url = "http://192.168.107.10/index.php/service/idcardservice/getIdcardInfo";
		String url = "http://10.255.34.110/index.php/service/idcardservice/getIdcardInfo";
		
		JSONObject jsonObj = new JSONObject();
     	jsonObj.element("cert_img_code_front", "hurcg4gu55m1kus3ns85w34ae8b4pjgd");
      	jsonObj.element("cert_img_key_front", "123");
      	jsonObj.element("cert_img_code_back", "8pksm7240ap8m5twvbc56hnf71t6hemg");
	    jsonObj.element("cert_img_key_back", "123");
	    jsonObj.element("appid", "211");
      	jsonObj.element("nonce_str", "2345677");
      	jsonObj.element("sign_type", "2232");
	    jsonObj.element("sign", "a");
	    try {
//	    	retJson = PostJsonRequest.PostJson(url, jsonObj);
	    	JSONObject retJson = HttpRequestUtils.httpPost(url, jsonObj);
			System.out.println(retJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		
	}
	
	
	public void EsbSendMailTest(){
		String testTableName = "rrs_grzx_bf_base_info_loan_test";
		String pzkey = "1000";
		HashMap<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("business_num", "8600020000014634G1283704292660386401");
		conditionMap.put("ds", "2037-07-21");
		
		ArrayList<String> contrastList = new ArrayList<String>();
		contrastList.add("account_status");
		contrastList.add("act_pay_amount");
		contrastList.add("balance");
		contrastList.add("billing_date");
		contrastList.add("business_detail");
		
		JSONObject json = new JSONObject();
		json.put("testTableName", testTableName);
		json.put("pzkey", pzkey);
		JSONArray  jsonArray = JSONArray.fromObject(contrastList);
		json.put("contrastList", jsonArray);
		json.put("conditionMap", conditionMap);
		
		String url = "http://192.168.107.51:8081/contrast/httpService";
		
		JSONObject result = HttpRequestUtils.httpPost(url, json);
		System.out.println(result.toString());
	}


}
	

