package com.demo.spring_rest_demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.spring_rest_demo.pojo.ProductPojo;

public class ProductDaoCollectionImpl implements ProductDao{

	List<ProductPojo> productDataStore = null;
	
	public ProductDaoCollectionImpl() {
		productDataStore = new ArrayList<ProductPojo>();
		productDataStore.add(new ProductPojo(101, "Laptop", 30000, "New laptop", ""));
		productDataStore.add(new ProductPojo(102, "Mobile", 20000, "New mobile", ""));
		productDataStore.add(new ProductPojo(103, "Smart Watch", 10000, "New watch", ""));
	}

	@Override
	public List<ProductPojo> getAllProducts() {
		return productDataStore;
	}

	@Override
	public ProductPojo getAProduct(int productId) {
		for(int i=0;i<productDataStore.size();i++) {
			if(productDataStore.get(i).getProductId() == productId) {
				return productDataStore.get(i);
			}
		}
		return null;
	}

	@Override
	public ProductPojo addProduct(ProductPojo newProduct) {
		int newProductId = productDataStore.get(productDataStore.size()-1).getProductId() + 1;
		newProduct.setProductId(newProductId);
		productDataStore.add(newProduct);
		return newProduct;
	}

	@Override
	public ProductPojo updateProduct(ProductPojo editProduct) {
		
		return null;
	}

	@Override
	public void deleteProduct(int productId) {
//		for(int i=0;i<productDataStore.size();i++) {
//			if(productDataStore.get(i).getProductId() == productId) {
//				productDataStore.remove(i);
//			}
//		}
		productDataStore = productDataStore
							.stream()
							.filter((eachProduct)->eachProduct.getProductId()!=productId)
							.collect(Collectors.toList());
		
	}

}
