package com.onlinesareesshoppingsystem.dao;

import java.util.List;

import com.onlinesareesshoppingsystem.entities.Cashondelivery;

public interface Cashondeliverydao {
	Cashondelivery getCashOnDeliveryById(int codId);
	void addCashOnDelivery(Cashondelivery cashOnDelivery);
	void updateCashOnDelivery(Cashondelivery cashOnDelivery);
	void deleteCashOnDelivery(int codId);
	List<Cashondelivery> getAllCashOnDeliveries();
	void insert(Cashondelivery codobj);
	Cashondelivery getcashondelivery(int codId, int mobNo, String status);
}

