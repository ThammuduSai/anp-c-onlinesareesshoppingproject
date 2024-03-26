package com.onlinesareesshoppingsystem.dao;

import java.util.List;

import com.onlinesareesshoppingsystem.entities.Payment;

public interface Paymentdao {
	Payment getPaymentById(int paymentId);
	void addPayment(Payment payment);
	void updatePayment(Payment payment);
	void deletePayment(int paymentId);
	List<Payment> getAllPayments();
}
