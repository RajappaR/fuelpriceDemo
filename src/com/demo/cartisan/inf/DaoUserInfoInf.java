package com.demo.cartisan.inf;

import java.util.ArrayList;

import com.demo.cartisan.models.UserInfo;

public interface DaoUserInfoInf {

	public boolean addUserInfo(UserInfo userInfo);
	
	public boolean updateUserInfo(String mobile,UserInfo userInfo);
	
	public boolean deleteUserInfo(String mobile);
	
	public ArrayList<UserInfo> getAllUserInfo();
	
	public UserInfo getUserInfoByMobile(String mobile);
}
