package com.controller.demo.domain;

public class OrdersDetail {
private int orderId,number;
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
private String productCode,quantityOrder,priceEach;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getProductCode() {
	return productCode;
}
public void setProductCode(String productCode) {
	this.productCode = productCode;
}
public String getQuantityOrder() {
	return quantityOrder;
}
public void setQuantityOrder(String quantityOrder) {
	this.quantityOrder = quantityOrder;
}
public String getPriceEach() {
	return priceEach;
}
public void setPriceEach(String priceEach) {
	this.priceEach = priceEach;
}

}
