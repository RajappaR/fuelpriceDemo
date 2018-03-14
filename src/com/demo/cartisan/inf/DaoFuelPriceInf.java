package com.demo.cartisan.inf;

import java.util.ArrayList;

import com.demo.cartisan.models.FuelPrice;

public interface DaoFuelPriceInf {
	
	public boolean addFuelPrice(FuelPrice fuelPrice);
	
	public boolean updateFuelPrice(int id,FuelPrice fuelPrice);
	
	public boolean deleteFuelPriceData(int id);
	
	public FuelPrice getFuelPriceByCity(String city);
	
	public ArrayList<FuelPrice> getAllCityFuelPrice();
	
	public FuelPrice getFuelPriceById(int id);
	

}
