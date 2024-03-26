package com.onlinesareesshopping.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cashondelivery")
public class Cashondelivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codId;
	private int paymentId; // Foreign key to Payment table
	private int mobNo;
	private String address;
	private int Payment;
	private String status;

	@OneToOne(mappedBy = "cashOnDelivery")
	private Payment payment;

	public int getCodId() {
		return codId;
	}

	public void setCodId(int codId) {
		this.codId = codId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getMobNo() {
		return mobNo;
	}

	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPayment1() {
		return Payment;
	}

	public void setPayment(int payment) {
		Payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Cashondelivery [codId=" + codId + ", paymentId=" + paymentId + ", mobNo=" + mobNo + ", address="
				+ address + ", Payment=" + Payment + ", status=" + status + ", payment=" + payment + "]";
	}

	public Cashondelivery() {
		super();
		// TODO Auto-generated constructor stub
	}

}


