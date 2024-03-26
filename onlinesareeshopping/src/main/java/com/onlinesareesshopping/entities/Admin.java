package com.onlinesareesshopping.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
	@Table(name = "admin")
	public class Admin {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int adminid;

	    @Column(name = "admin_name")
	    private String adminName;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "mobile")
	    private int mobile;

	    @Column(name = "password")
	    private String password;
@OneToOne
	    @JoinColumn(name = "register_id")
	    private Register register;

		public int getId() {
			return adminid;
		}

		public void setId(int id) {
			this.adminid = id;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getMobile() {
			return mobile;
		}

		public void setMobile(int mobile) {
			this.mobile = mobile;
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

		@Override
		public String toString() {
			return "Admin [id=" + adminid + ", adminName=" + adminName + ", email=" + email + ", mobile=" + mobile
					+ ", password=" + password + ", register=" + register + "]";
		}

		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Session getSession() {
			// TODO Auto-generated method stub
			return null;
		}
	    
	    
	}