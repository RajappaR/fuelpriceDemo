package com.demo.cartisan.service;

import java.util.ArrayList;

import com.demo.cartisan.dao.DaoImpl;
import com.demo.cartisan.inf.DaoInf;
import com.demo.cartisan.inf.ServiceInf;
import com.demo.cartisan.models.FuelPrice;
import com.demo.cartisan.models.LogInfo;
import com.demo.cartisan.models.UserInfo;

public class ServiceImplementation implements ServiceInf{
	
	DaoInf daoInf;
	
	public ServiceImplementation() {
		daoInf = new DaoImpl();
	}

	@Override
	public boolean addFuelPrice(FuelPrice fuelPrice) {
		return daoInf.addFuelPrice(fuelPrice);
	}

	@Override
	public boolean updateFuelPrice(int id, FuelPrice fuelPrice) {
		return daoInf.updateFuelPrice(id, fuelPrice);
	}

	@Override
	public boolean deleteFuelPriceData(int id) {
		return daoInf.deleteFuelPriceData(id);
	}

	@Override
	public FuelPrice getFuelPriceByCity(String city) {
		return daoInf.getFuelPriceByCity(city);
	}

	@Override
	public ArrayList<FuelPrice> getAllCityFuelPrice() {
		return daoInf.getAllCityFuelPrice();
	}

	@Override
	public FuelPrice getFuelPriceById(int id) {
		return daoInf.getFuelPriceById(id);
	}

	@Override
	public boolean addLogInfo(LogInfo logInfo) {
		return daoInf.addLogInfo(logInfo);
	}

	@Override
	public boolean updateLogInfo(int id, LogInfo logInfo) {
		return daoInf.updateLogInfo(id, logInfo);
	}

	@Override
	public boolean deleteLogInfoData(int id) {
		return daoInf.deleteLogInfoData(id);
	}

	@Override
	public ArrayList<LogInfo> getLogInfoByMobile(String mobile) {
		return daoInf.getLogInfoByMobile(mobile);
	}

	@Override
	public LogInfo getLogInfoById(int id) {
		return daoInf.getLogInfoById(id);
	}

	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		return daoInf.addUserInfo(userInfo);
	}

	@Override
	public boolean updateUserInfo(String mobile, UserInfo userInfo) {
		return daoInf.updateUserInfo(mobile, userInfo);
	}

	@Override
	public boolean deleteUserInfo(String mobile) {
		return daoInf.deleteUserInfo(mobile);
	}

	@Override
	public ArrayList<UserInfo> getAllUserInfo() {
		return daoInf.getAllUserInfo();
	}

	@Override
	public UserInfo getUserInfoByMobile(String mobile) {
		return daoInf.getUserInfoByMobile(mobile);
	}

}
