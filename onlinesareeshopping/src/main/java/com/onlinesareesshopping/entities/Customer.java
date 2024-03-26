package com.onlinesareesshopping.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
	@Table(name = "customer")
	public class Customer {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int custid;

	    @Column(name = "cust_name")
	    private String custName;

	    @Column(name = "cust_add")
	    private String custAdd;

	    @Column(name = "cust_email")
	    private String custEmail;

	    @Column(name = "gender")
	    private String gender;

	    @Column(name = "cust_mobile")
	    private int custMobile;

	    @Column(name = "password")
	    private String password;

	  @OneToOne
	    @JoinColumn(name = "register_id")
	    private Register register;

		public int getCustid() {
			return custid;
		}

		public void setCustid(int custid) {
			this.custid = custid;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getCustAdd() {
			return custAdd;
		}

		public void setCustAdd(String custAdd) {
			this.custAdd = custAdd;
		}

		public String getCustEmail() {
			return custEmail;
		}

		public void setCustEmail(String custEmail) {
			this.custEmail = custEmail;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getCustMobile() {
			return custMobile;
		}

		public void setCustMobile(int custMobile) {
			this.custMobile = custMobile;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Register getRegister() {
			return register;
		}

		public void setRegister(Register register) {
			this.register = register;
		}

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Customer [custid=" + custid + ", custName=" + custName + ", custAdd=" + custAdd + ", custEmail="
					+ custEmail + ", gender=" + gender + ", custMobile=" + custMobile + ", password=" + password
					+ ", register=" + register + "]";
		}

	   
	}