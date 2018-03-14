package com.demo.cartisan.dao;

import java.util.ArrayList;

import com.demo.cartisan.inf.DaoInf;
import com.demo.cartisan.models.FuelPrice;
import com.demo.cartisan.models.LogInfo;
import com.demo.cartisan.models.UserInfo;

public class DaoImpl implements DaoInf {

	@Override
	public boolean addFuelPrice(FuelPrice fuelPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFuelPrice(int id, FuelPrice fuelPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFuelPriceData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FuelPrice getFuelPriceByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FuelPrice> getAllCityFuelPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuelPrice getFuelPriceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addLogInfo(LogInfo logInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLogInfo(int id, LogInfo logInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLogInfoData(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<LogInfo> getLogInfoByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogInfo getLogInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserInfo(String mobile, UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserInfo(String mobile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UserInfo> getAllUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserInfoByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

}
