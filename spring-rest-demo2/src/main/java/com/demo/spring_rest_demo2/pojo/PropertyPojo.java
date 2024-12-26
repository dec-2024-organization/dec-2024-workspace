package com.demo.spring_rest_demo2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyPojo {
	private int propertyId;
	private String propertyName;
	private String propertyDescription;
	private String propertyLocation;
	private String propertyImageUrl;
}
