package com.example.client.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.example.client.models.UserInfo;
import com.example.client.utils.CommonUtil;
import com.example.client.utils.WebServiceInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.core.util.Base64Encoder;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class UserServiceImpl implements UserService {

	private final String USER_AGENT = "Mozilla/5.0";

	@Override
	public UserInfo getUserInfo(long userId) throws Exception {
		
		URL obj = new URL(WebServiceInfo.userListUrl+userId);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		String encoding = CommonUtil.getInstance().getEncodedAuth();
		// optional default is GET
		con.setRequestMethod("GET");
		con.setDoInput(true);
		con.setRequestProperty("Authorization", "Basic " + encoding);

		// add request header
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + WebServiceInfo.userListUrl);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());
//		Type listType = new TypeToken<List<UserInfo>>() {}.getType();
		UserInfo user = new Gson().fromJson(response.toString(), UserInfo.class);
		return user;
	}

	@Override
	public List<UserInfo> getUserList() throws Exception {

		URL obj = new URL(WebServiceInfo.userListUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		String encoding = CommonUtil.getInstance().getEncodedAuth();
		// optional default is GET
		con.setRequestMethod("GET");
		con.setDoInput(true);
		con.setRequestProperty("Authorization", "Basic " + encoding);

		// add request header
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + WebServiceInfo.userListUrl);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());
		Type listType = new TypeToken<List<UserInfo>>() {}.getType();
		List<UserInfo> yourList = new Gson().fromJson(response.toString(), listType);
		return yourList;
	}

	@Override
	public UserInfo addUser(UserInfo u) throws Exception{
		URL obj = new URL(WebServiceInfo.userListUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		String encoding = CommonUtil.getInstance().getEncodedAuth();
		con.setDoOutput(true);
		con.setRequestProperty("Authorization", "Basic " + encoding);
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		System.out.println(new Gson().toJson(u));
		wr.write(new Gson().toJson(u).getBytes());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	}

	@Override
	public UserInfo updateUser(UserInfo u) throws Exception{
		URL obj = new URL(WebServiceInfo.userListUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("PUT");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");
		String encoding = CommonUtil.getInstance().getEncodedAuth();
		con.setDoOutput(true);
		con.setRequestProperty("Authorization", "Basic " + encoding);
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		System.out.println(new Gson().toJson(u));
		wr.write(new Gson().toJson(u).getBytes());
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
		return null;
	}

	@Override
	public boolean deleteUserInfo(long userId) {
		try {
			URL obj = new URL(WebServiceInfo.userListUrl+userId);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			String encoding = CommonUtil.getInstance().getEncodedAuth();
			con.setRequestMethod("DELETE");
			con.setDoInput(true);
			con.setRequestProperty("Authorization", "Basic " + encoding);

			// add request header
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + WebServiceInfo.userListUrl);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

}
