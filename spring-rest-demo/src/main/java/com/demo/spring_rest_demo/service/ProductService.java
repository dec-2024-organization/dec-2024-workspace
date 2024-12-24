package com.demo.spring_rest_demo.service;

import java.util.List;

import com.demo.spring_rest_demo.pojo.ProductPojo;

public interface ProductService {
	List<ProductPojo> getAllProducts();
	ProductPojo getAProduct(int productId);
	ProductPojo addProduct(ProductPojo newProduct);
	ProductPojo updateProduct(ProductPojo editProduct);
	void deleteProduct(int productId);
}
