package com.demo.cartisan.dao;

import java.util.ArrayList;

import com.demo.cartisan.inf.DaoInf;
import com.demo.cartisan.models.FuelPrice;
import com.demo.cartisan.models.LogInfo;
import com.demo.cartisan.models.UserInfo;

public class DaoImpl implements DaoInf {

	@Override
	public boolean addFuelPrice(FuelPrice fuelPrice) {
		
		return false;
	}

	@Override
	public boolean updateFuelPrice(int id, FuelPrice fuelPrice) {
		
		return false;
	}

	@Override
	public boolean deleteFuelPriceData(int id) {
		
		return false;
	}

	@Override
	public FuelPrice getFuelPriceByCity(String city) {
		
		return null;
	}

	@Override
	public ArrayList<FuelPrice> getAllCityFuelPrice() {
		
		return null;
	}

	@Override
	public FuelPrice getFuelPriceById(int id) {
		
		return null;
	}

	@Override
	public boolean addLogInfo(LogInfo logInfo) {
		
		return false;
	}

	@Override
	public boolean updateLogInfo(int id, LogInfo logInfo) {
		
		return false;
	}

	@Override
	public boolean deleteLogInfoData(int id) {
		
		return false;
	}

	@Override
	public ArrayList<LogInfo> getLogInfoByMobile(String mobile) {
		
		return null;
	}

	@Override
	public LogInfo getLogInfoById(int id) {
		
		return null;
	}

	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		
		return false;
	}

	@Override
	public boolean updateUserInfo(String mobile, UserInfo userInfo) {
		
		return false;
	}

	@Override
	public boolean deleteUserInfo(String mobile) {
		
		return false;
	}

	@Override
	public ArrayList<UserInfo> getAllUserInfo() {
		
		return null;
	}

	@Override
	public UserInfo getUserInfoByMobile(String mobile) {
		
		return null;
	}

}
