package com.onlinesareesshopping.entities;

import java.util.Date;
import java.util.HashSet;
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
 private int totalamount;
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
public int getTotalamount() {
	return totalamount;
}
public void setTotalamount(int totalamount) {
	this.totalamount = totalamount;
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
 
}
