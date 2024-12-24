package com.demo.spring_rest_demo.dao;

import java.util.List;

import com.demo.spring_rest_demo.pojo.ProductPojo;

public interface ProductDao {
	List<ProductPojo> getAllProducts();
	ProductPojo getAProduct(int productId);
	ProductPojo addProduct(ProductPojo newProduct);
	ProductPojo updateProduct(ProductPojo editProduct);
	void deleteProduct(int productId);
}
