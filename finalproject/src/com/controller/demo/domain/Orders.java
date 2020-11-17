package com.controller.demo.domain;

public class Orders {
private int orderId,companyId;
private String orderDate,shipDate,amount;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public String getShipDate() {
	return shipDate;
}
public void setShipDate(String shipDate) {
	this.shipDate = shipDate;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}

}
