package com.demo.cartisan.inf;

import java.util.ArrayList;

import com.demo.cartisan.models.LogInfo;

public interface DaoLogInfoInf {
	
	public boolean addLogInfo(LogInfo logInfo);
	
	public boolean updateLogInfo(int id,LogInfo logInfo);
	
	public boolean deleteLogInfoData(int id);
	
	public ArrayList<LogInfo> getLogInfoByMobile(String mobile);
	
	public LogInfo getLogInfoById(int id);
	
}
