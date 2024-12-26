package com.demo.spring_rest_demo2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.spring_rest_demo2.pojo.PropertyPojo;

public class PropertyDaoJdbcImpl implements PropertyDao{

	// JDBC steps
	// 1. Load the driver - once
	// 2. Establish connection to the DB - once
	// 3. Create a Statement/PreparedSatement and execute it - each functionality
	// 4. Handle the exceptions - each functionality
	// 5. Close the connection - once
	
	@Override
	public List<PropertyPojo> getAllProperties() {
		List<PropertyPojo> allProperties = new ArrayList<PropertyPojo>();
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from property_details";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				allProperties.add(new PropertyPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allProperties;
	}

	@Override
	public PropertyPojo getAProperty(int propertyId) {
		PropertyPojo fetchedProperty = null;
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from property_details where property_id=" + propertyId;
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				fetchedProperty = new PropertyPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fetchedProperty;
	}

	@Override
	public PropertyPojo addProperty(PropertyPojo newProperty) {
		Connection conn = DBUtil.makeConnection();
		try {
			String query = "insert into property_details(property_name, property_description, property_location, property_image_url) values (?, ?, ?, ?);";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newProperty.getPropertyName());
			stmt.setString(2, newProperty.getPropertyDescription());
			stmt.setString(3, newProperty.getPropertyLocation());
			stmt.setString(4, newProperty.getPropertyImageUrl());
			stmt.executeUpdate(query);
			
			query = " select last_insert_id()";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if((rs.next())) {
				newProperty.setPropertyId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newProperty;
	}

	@Override
	public PropertyPojo updateProperty(PropertyPojo editProperty) {
		Connection conn = DBUtil.makeConnection();
		try {
			String query = "update property_details set property_location=? where property_id=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, editProperty.getPropertyLocation());
			stmt.setString(2, editProperty.getPropertyLocation());
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editProperty;
	}

	@Override
	public void deleteProperty(int propertyId) {
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "delete from property_details where property_id=" + propertyId;
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
