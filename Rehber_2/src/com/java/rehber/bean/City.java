package com.java.rehber.bean;

public class City {
	
	public static City[] cities;
	
	static{
		cities = new City[3];
		City newCity = new City();
		newCity.setCityCode(34);
		newCity.setCityName("istanbul");
		cities[0] = newCity;
		City newCity1 = new City();
		newCity1.setCityCode(1);
		newCity1.setCityName("adana");
		cities[1] = newCity1;
		City newCity2 = new City();
		newCity2.setCityCode(35);
		newCity2.setCityName("izmir");
		cities[2] = newCity2;
	}
	
	
	private int cityCode;
	private String cityName;
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
