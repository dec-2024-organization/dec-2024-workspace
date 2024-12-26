package com.demo.spring_rest_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_rest_demo.pojo.ProductPojo;
import com.demo.spring_rest_demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	//ProductService productService = new ProductServiceImpl();
	
	@GetMapping("/products")
	List<ProductPojo> getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	@GetMapping("/product/{pid}")
	ProductPojo getAProduct(@PathVariable("pid") int productId) {
		return productService.getAProduct(productId);
	}
	
	@PostMapping("/products")
	ProductPojo addProduct(@RequestBody ProductPojo newProduct) {
		return productService.addProduct(newProduct);
	}
	
	@PutMapping("/products")
	ProductPojo updateProduct(@RequestBody ProductPojo editProduct) {
		return productService.updateProduct(editProduct);
	}
	
	@DeleteMapping("/products/{productId}")
	void deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
	}
}
