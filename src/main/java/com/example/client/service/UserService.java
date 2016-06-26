package com.example.client.service;

import java.util.List;

import com.example.client.models.UserInfo;

public interface UserService {

	public UserInfo getUserInfo(long userId) throws Exception;
	
	public List<UserInfo> getUserList() throws Exception;
	
	public UserInfo addUser(UserInfo u) throws Exception;
	
	public UserInfo updateUser(UserInfo u) throws Exception;
	
	public boolean deleteUserInfo(long userId);
	
}
