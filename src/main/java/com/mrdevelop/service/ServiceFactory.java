package com.mrdevelop.service;

import com.mrdevelop.service.impl.CarServiceImpl;

public class ServiceFactory {
	
	public static CarService getCarService(){
		return new CarServiceImpl();
	}

}
