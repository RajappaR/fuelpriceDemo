package com.demo.cartisan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.cartisan.inf.ServiceInf;
import com.demo.cartisan.models.FuelPrice;
import com.demo.cartisan.models.LogInfo;
import com.demo.cartisan.models.UserInfo;
import com.demo.cartisan.service.ServiceImplementation;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class Controller extends HttpServlet{
	
	private Logger LOGGER = Logger.getLogger(Controller.class.getName());
	
	private ServiceInf serviceInf;

	public Controller() {
		serviceInf = new ServiceImplementation();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
			
		if (uri.endsWith("getFuelPriceByCity.do")) {
			
			String city = req.getParameter("city");
			FuelPrice fuelPrice = serviceInf.getFuelPriceByCity(city);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			resp.getWriter().write(fuelPrice.toString());
			
		}else if(uri.endsWith("getAllCityPrice.do")) {
			
			ArrayList<FuelPrice> fuelPriceList = serviceInf.getAllCityFuelPrice();
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			resp.getWriter().write(fuelPriceList.toString());
			
		}else if(uri.endsWith("addFuelPrice.do")) {
			
			String currDate = req.getParameter("curDate");
			String city = req.getParameter("city");
			double curPetrolPrice = Double.parseDouble(req.getParameter("curPetrolPrice").trim());
			double curDieselPrice = Double.parseDouble(req.getParameter("curDieselPrice").trim());
			double prvPetrolPrice = Double.parseDouble(req.getParameter("prvPetrolPrice").trim());
			double prvDieselPrice = Double.parseDouble(req.getParameter("prvDieselPrice").trim());
			
			FuelPrice fuelPrice = new FuelPrice();
			fuelPrice.setmCity(city);
			fuelPrice.setmCurrentDate(currDate);
			fuelPrice.setmCurPetrolPrice(curPetrolPrice);
			fuelPrice.setmCurDieselPrice(curDieselPrice);
			fuelPrice.setmPrvPetrolPrice(prvPetrolPrice);
			fuelPrice.setmPrvDieselPrice(prvDieselPrice);
			
			
			boolean isAdded = serviceInf.addFuelPrice(fuelPrice);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			if(isAdded) {
				resp.getWriter().write("Fuel Price Added Successfully");
			}else {
				resp.getWriter().write("Error Occurred in Adding Fuel Price");
			}
			
		}else if(uri.endsWith("addLogInfo.do")) {
			
			String logDate = req.getParameter("logDate");
			String stationName = req.getParameter("stationName");
			String userMobile = req.getParameter("userMobile");
			double amount = Double.parseDouble(req.getParameter("amount").trim());
			double liters = Double.parseDouble(req.getParameter("liters").trim());
			String fuelType =req.getParameter("fuelType");
			String comments =req.getParameter("comments");
			
			LogInfo logInfo = new LogInfo();
			logInfo.setGasStationName(stationName);
			logInfo.setmUserMobile(userMobile);
			logInfo.setmLogDate(logDate);
			logInfo.setmComments(comments);
			logInfo.setmLiters(liters);
			logInfo.setmFuelType(fuelType);
			
			
			
			boolean isAdded = serviceInf.addLogInfo(logInfo);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			if(isAdded) {
				resp.getWriter().write("Log Information Added Successfully");
			}else {
				resp.getWriter().write("Error Occurred in Adding Log Information");
			}
			
		}else if(uri.endsWith("getLogInfoByMobile.do")) {
			
			String mobile = req.getParameter("mobile");
			ArrayList<LogInfo> logInfos = serviceInf.getLogInfoByMobile(mobile);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			resp.getWriter().write(logInfos.toString());
			
		}else if(uri.endsWith("getLogInfoById.do")) {
			
			int id = Integer.parseInt(req.getParameter("id").trim());
			LogInfo logInfo = serviceInf.getLogInfoById(id);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			resp.getWriter().write(logInfo.toString());
			
		}else if(uri.endsWith("addUserInfo.do")) {
			
			String name = req.getParameter("name");
			String mobile = req.getParameter("mobile");
			String email = req.getParameter("email");
			
			
			UserInfo userInfo = new UserInfo();
			userInfo.setmName(name);
			userInfo.setmMobile(mobile);
			userInfo.setmEmail(email);
			
			
			boolean isAdded = serviceInf.addUserInfo(userInfo);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			if(isAdded) {
				resp.getWriter().write("User Information Added Successfully");
			}else {
				resp.getWriter().write("Error Occurred in Adding User Information");
			}
			
		}else if(uri.endsWith("getUserInfoByMobile.do")) {
			
			String mobile = req.getParameter("mobile");
			UserInfo userInfo = serviceInf.getUserInfoByMobile(mobile);
			
			resp.setContentType("application/json");
			resp.getWriter().flush();
			resp.getWriter().write(userInfo.toString());
			
		}
	}
}
