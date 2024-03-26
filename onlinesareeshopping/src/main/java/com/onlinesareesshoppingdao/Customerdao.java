package com.onlinesareesshoppingdao;


import com.onlinesareesshopping.entities.Customer;

public interface Customerdao {
	void insert(Customer customer);
Customer getCustomerByEmailAndPassword(String email, String password);
}
