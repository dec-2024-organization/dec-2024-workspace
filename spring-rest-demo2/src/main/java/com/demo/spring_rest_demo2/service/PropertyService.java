package com.demo.spring_rest_demo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring_rest_demo2.dao.PropertyDao;
import com.demo.spring_rest_demo2.pojo.PropertyPojo;

@Service
public class PropertyService{

	@Autowired
	PropertyDao propertyDao;
	
	public List<PropertyPojo> getAllProperties() {
		return propertyDao.getAllProperties();
	}

	public PropertyPojo getAProperty(int propertyId) {
		return propertyDao.getAProperty(propertyId);
	}

	public PropertyPojo addProperty(PropertyPojo newProperty) {
		return propertyDao.addProperty(newProperty);
	}

	public PropertyPojo updateProperty(PropertyPojo editProperty) {
		return propertyDao.updateProperty(editProperty);
	}

	public void deleteProperty(int propertyId) {
		propertyDao.deleteProperty(propertyId);
	}
}
