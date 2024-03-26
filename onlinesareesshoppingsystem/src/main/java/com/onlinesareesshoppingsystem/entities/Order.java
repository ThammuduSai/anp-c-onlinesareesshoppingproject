package com.onlinesareesshoppingsystem.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="order")
public class Order {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int orderid;
 private double totalamount;
 private Date orderdate;
 @ManyToMany
 @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "orderid"),
            inverseJoinColumns = @JoinColumn(name = "productid"))
 private Set<Products> products = new HashSet<>();
 
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public double getTotalamount() {
	return totalamount;
}
public void setTotalamount(double totalAmount2) {
	this.totalamount = totalAmount2;
}
public Date getOrderdate() {
	return orderdate;
}
public void setOrderdate(Date orderdate) {
	this.orderdate = orderdate;
}
public Set<Products> getProducts() {
	return products;
}
public void setProducts(Set<Products> products) {
	this.products = products;
}
@Override
public String toString() {
	return "Order [orderid=" + orderid + ", totalamount=" + totalamount + ", orderdate=" + orderdate + ", products="
			+ products + "]";
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public static List<Order> getAllOrders() {
	// TODO Auto-generated method stub
	return null;
}
public void setItemNumber(int itemNumber) {
	// TODO Auto-generated method stub
	
}
public void setQuantity(int quantity) {
	// TODO Auto-generated method stub
	
}
 
}
