package com.demo.spring_rest_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductPojo {
	private int productId;
	private String productName;
	private int productCost;
	private String productDescription;
	private String productImageUrl;
}
