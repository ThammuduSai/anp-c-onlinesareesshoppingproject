package com.onlinesareesshoppingsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orderitem {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int orderid;
 private int productid;
 private int orderitemid;
 @ManyToOne
 @JoinColumn(name = "order_id")
 private Order order;

 @ManyToOne
 @JoinColumn(name = "product_id")
 private Products product;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public int getOrderitemid() {
	return orderitemid;
}
public void setOrderitemid(int orderitemid) {
	this.orderitemid = orderitemid;
}
@Override
public String toString() {
	return "Orderitem [orderid=" + orderid + ", productid=" + productid + ", orderitemid=" + orderitemid + "]";
}
public Orderitem() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
