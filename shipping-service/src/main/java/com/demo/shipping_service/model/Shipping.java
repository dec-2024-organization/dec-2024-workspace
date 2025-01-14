package com.demo.shipping_service.model;

public class Shipping {
	private int shippingId;
	private String shippingStatus;
	private int orderId;
	
	public Shipping() {}

	public Shipping(String shippingStatus, int orderId) {
		super();
		this.shippingStatus = shippingStatus;
		this.orderId = orderId;
	}

	public Shipping(int shippingId, String shippingStatus, int orderId) {
		this.shippingId = shippingId;
		this.shippingStatus = shippingStatus;
		this.orderId = orderId;
	}

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", shippingStatus=" + shippingStatus + ", orderId=" + orderId
				+ "]";
	}
}
