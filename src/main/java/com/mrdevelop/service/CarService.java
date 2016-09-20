package com.mrdevelop.service;

import java.util.List;

import com.mrdevelop.model.Car;

public interface CarService {
	
	public List<Car> findAllByFilter(String filter);

}
