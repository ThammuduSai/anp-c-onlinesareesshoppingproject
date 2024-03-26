package com.onlinesareesshoppingsystem.dao;

import java.util.List;

import com.onlinesareesshoppingsystem.entities.Order;


public interface Orderdao {
	Order getOrderById(int orderId);
	void addOrder(Order order);
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	List<Order> getAllOrders();
}
