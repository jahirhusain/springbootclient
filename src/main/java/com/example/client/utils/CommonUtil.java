package com.example.client.utils;

import org.apache.commons.codec.binary.Base64;

public class CommonUtil {

	private static CommonUtil commonUtil;
	private CommonUtil() {
		
	}
	
	public static CommonUtil getInstance() {
		synchronized(CommonUtil.class) {
			if(commonUtil == null) {
				commonUtil = new CommonUtil();
			}
			return commonUtil;
		}		
	}
	
	public String getEncodedAuth() {
		String userName = WebServiceInfo.serverUserName;
		String password = WebServiceInfo.serverPassword;
		String authStr = userName + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authStr.getBytes());
		String authStringEnc = new String(authEncBytes);
		return authStringEnc;
	}
}
