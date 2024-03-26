package com.onlinesareesshoppingsystem.dao;


import com.onlinesareesshoppingsystem.entities.Customer;

public interface Customerdao {
	void insert(Customer customer);
Customer getCustomerByEmailAndPassword(String email, String password);
}
