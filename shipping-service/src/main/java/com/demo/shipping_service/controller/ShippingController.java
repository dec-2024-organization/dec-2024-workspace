package com.demo.shipping_service.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shipping_service.model.Shipping;

@RestController
@RequestMapping("/api")
public class ShippingController {

	List<Shipping> allShippings = new ArrayList<>(Arrays.asList(new Shipping(1,"INITIATED",1)));
	
	@GetMapping("/shippings")
	public ResponseEntity<List<Shipping>> getAllShippings(){
		return new ResponseEntity<List<Shipping>>(allShippings, HttpStatus.OK);
	}
	
	@GetMapping("/shippings/order/{orderId}")
	public ResponseEntity<Shipping> getShippingByOrder(@PathVariable int orderId){
		return new ResponseEntity<Shipping>(allShippings
												.stream()
												.filter((eachShipping) -> eachShipping.getOrderId()==orderId)
												.toList()
												.get(0),
												HttpStatus.OK);
	}
	
	@PostMapping("/shippings")
	public ResponseEntity<Shipping> addShipping(@RequestBody Shipping shipping){
		int newId = (allShippings.size()==0)?1:(allShippings.get(allShippings.size()-1).getShippingId() + 1);
		shipping.setShippingId(newId);
		allShippings.add(shipping);
		return new ResponseEntity<Shipping>(shipping, HttpStatus.OK);
	}
}
