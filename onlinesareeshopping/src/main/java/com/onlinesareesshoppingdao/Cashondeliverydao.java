package com.onlinesareesshoppingdao;

import java.util.List;

import com.onlinesareesshopping.entities.Cashondelivery;

public interface Cashondeliverydao {
	Cashondelivery getCashOnDeliveryById(int codId);
	void addCashOnDelivery(Cashondelivery cashOnDelivery);
	void updateCashOnDelivery(Cashondelivery cashOnDelivery);
	void deleteCashOnDelivery(int codId);
	List<Cashondelivery> getAllCashOnDeliveries();
}

