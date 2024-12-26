package com.demo.spring_rest_demo2.dao;

import java.util.List;

import com.demo.spring_rest_demo2.pojo.PropertyPojo;

public interface PropertyDao {
	List<PropertyPojo> getAllProperties();
	PropertyPojo getAProperty(int propertyId);
	PropertyPojo addProperty(PropertyPojo newProperty);
	PropertyPojo updateProperty(PropertyPojo editProperty);
	void deleteProperty(int propertyId);
}
