package com.onlinesareesshopping.entities;


	

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

	@Entity
	@Table(name = "payment")
	public class Payment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int paymentId;
	    private int paymentDate;
private int orderid;
@OneToOne
@JoinColumn(name = "paymentId")
private Cashondelivery cashOnDelivery;

		public int getPaymentId() {
			return paymentId;
		}
		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}
		public int getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(int paymentDate) {
			this.paymentDate = paymentDate;
		}
		public int getOrderid() {
			return orderid;
		}
		public void setOrderid(int orderid) {
			this.orderid = orderid;
		}
		
		@Override
		public String toString() {
			return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", orderid=" + orderid
					+ "]";
		}
		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	}


