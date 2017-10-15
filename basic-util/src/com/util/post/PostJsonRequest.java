package com.util.post;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class PostJsonRequest {
	
	@SuppressWarnings("deprecation")
	public static String PostJson(String url, JSONObject jsonObj)  throws Exception {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		method.setRequestHeader("Content-Type", "application/json;charset=utf-8");
		String postBody = BuildJSONPostData(jsonObj);
		System.out.println("postBody:\r\n" + postBody);
		method.setRequestBody(postBody);
		String respStr = "";
		try {
			int statusCode = client.executeMethod(method);

			System.out.println("Status Code = " + statusCode);

			respStr = method.getResponseBodyAsString();
			System.out.println("respStr:" + respStr);
			method.releaseConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return respStr;
	}
	
	private static String BuildJSONPostData(JSONObject jsonObj) {
		StringBuilder sb = new StringBuilder();
	    System.out.println(jsonObj.toString());
		sb.append(jsonObj.toString());
		sb.append("\r\n");
		sb.append("\r\n");
		return sb.toString();
	}

	
	@SuppressWarnings("deprecation")
	public static String PostForm(String url, String formStr)  throws Exception {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		String postBody = BuildFormPostData(formStr);
		System.out.println("postBody:\r\n" + postBody);
		method.setRequestBody(postBody);
		String respStr = "";
		try {
			int statusCode = client.executeMethod(method);

			System.out.println("Status Code = " + statusCode);

			respStr = method.getResponseBodyAsString();
			//System.out.println("respStr:" + respStr);
			method.releaseConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return respStr;
	}
	
	private static String BuildFormPostData(String formStr) {
		StringBuilder sb = new StringBuilder();
	    System.out.println(formStr.toString());
		sb.append(formStr.toString());
		sb.append("\r\n");
		sb.append("\r\n");
		return sb.toString();
	}
}
