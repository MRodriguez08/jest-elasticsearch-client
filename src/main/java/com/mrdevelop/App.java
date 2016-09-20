package com.mrdevelop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrdevelop.model.Car;
import com.mrdevelop.service.CarService;
import com.mrdevelop.service.ServiceFactory;

/**
 * elastic search jest client
 * @author mrodriguez
 */
public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		LOGGER.debug("ElasticSearch Jest Client Integration");
		CarService service = ServiceFactory.getCarService();
		String filter = "Huracan";
		List<Car> cars = service.findAllByFilter(filter);
		LOGGER.info("#################### RESULTS ####################");
		for (Car car : cars){
			LOGGER.info("{}", car);
		}
	}
	
}
