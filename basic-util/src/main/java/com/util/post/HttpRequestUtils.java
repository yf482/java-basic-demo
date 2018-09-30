package com.util.post;

//import org.apache.commons.httpclient.HttpStatus;

public class HttpRequestUtils {

	/**
	 * httpPost
	 * @param url      路径
	 * @param jsonParam     参数
	 * @return
	 *//*

	public statiproxy JSONObject httpPost(String url, JSONObject jsonParam) {

		return httpPost(url, jsonParam, false);

	}

	*//**
	 * 
	 * post请求
	 * @param url   url地址
	 * @param jsonParam     参数
	 * @param noNeedResponse      不需要返回结果
	 * @return
	 *//*

	public statiproxy JSONObject httpPost(String url, JSONObject jsonParam,
			boolean noNeedResponse) {

		// post请求返回结果

		DefaultHttpClient httpClient = new DefaultHttpClient();

		JSONObject jsonResult = null;

		HttpPost method = new HttpPost(url);

		try {

			if (null != jsonParam) {

				// 解决中文乱码问题

				StringEntity entity = new StringEntity(jsonParam.toString(),
						"utf-8");

				entity.setContentEncoding("UTF-8");

				entity.setContentType("application/json;charset=utf-8");
//				entity.setContentType("application/json");

				method.setEntity(entity);

			}

			HttpResponse result = httpClient.execute(method);

			url = URLDecoder.decode(url, "UTF-8");

			*//** 请求发送成功，并得到响应 **//*

			if (result.getStatusLine().getStatusCode() == 200) {

				String str = "";

				try {

					*//** 读取服务器返回过来的json字符串数据 **//*

					str = EntityUtils.toString(result.getEntity());

					if (noNeedResponse) {

						return null;

					}

					*//** 把json字符串转换成json对象 **//*

					jsonResult = JSONObject.fromObject(str);

				} catch (Exception e) {

					//logger.error("post请求提交失败:" + url, e);

				}

			}

		} catch (IOException e) {

			logger.error("post请求提交失败:" + url, e);

		}

		return jsonResult;

	}*/

	/**
	 * 
	 * 发送get请求
	 * @param url   路径
	 * @return
	 */

	/*public statiproxy JSONObject httpGet(String url) {

		// get请求返回结果

		JSONObject jsonResult = null;

		try {

			DefaultHttpClient client = new DefaultHttpClient();

			// 发送get请求

			HttpGet request = new HttpGet(url);

			HttpResponse response = client.execute(request);

			*//** 请求发送成功，并得到响应 **//*

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				*//** 读取服务器返回过来的json字符串数据 **//*

				String strResult = EntityUtils.toString(response.getEntity());

				*//** 把json字符串转换成json对象 **//*

				jsonResult = JSONObject.fromObject(strResult);

				url = URLDecoder.decode(url, "UTF-8");

			} else {

				logger.error("get请求提交失败:" + url);

			}

		} catch (IOException e) {

			logger.error("get请求提交失败:" + url, e);

		}

		return jsonResult;

	}*/

	

}
