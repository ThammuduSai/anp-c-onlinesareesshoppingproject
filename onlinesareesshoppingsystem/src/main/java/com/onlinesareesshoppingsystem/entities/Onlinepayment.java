package com.onlinesareesshoppingsystem.entities;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

	@Entity
	@Table(name = "Online_Payment")
	public class Onlinepayment {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Online_Id")
		private int onlineId;

		@Column(name = "UPi_Payment")
		private int upiPayment;

		@Column(name = "Card_Payment")
		private int cardPayment;

		@Column(name = "Net_Banking")
		private int netBanking;

		@OneToOne
		@JoinColumn(name = "Payment_Id", referencedColumnName = "Payment_Id")
		private Payment payment;

		
	}


