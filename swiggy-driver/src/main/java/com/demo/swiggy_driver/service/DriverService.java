package com.demo.swiggy_driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.swiggy_driver.constant.AppConstant;

@Service
public class DriverService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void driverLocation() {
		int range = 20;
		String location = "";
		while(range > 0) {
			location = (Math.random() * 100) + " : " + (Math.random() * 100);
			System.out.println(location);
			kafkaTemplate.send(AppConstant.TOPIC_DRIVER_LOCATION, location);
			range--;
		}
	}
}
