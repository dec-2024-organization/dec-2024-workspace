package com.demo.spring_rest_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring_rest_demo.dao.ProductDao;
import com.demo.spring_rest_demo.pojo.ProductPojo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	//ProductDao productDao = new ProductDaoCollectionImpl();
	
	@Override
	public List<ProductPojo> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public ProductPojo getAProduct(int productId) {
		return productDao.getAProduct(productId);
	}

	@Override
	public ProductPojo addProduct(ProductPojo newProduct) {
		return productDao.addProduct(newProduct);
	}

	@Override
	public ProductPojo updateProduct(ProductPojo editProduct) {
		return productDao.updateProduct(editProduct);
	}

	@Override
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}
}
