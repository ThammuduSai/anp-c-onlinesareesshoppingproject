package com.onlinesareesshopping.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade=CascadeType.ALL,mappedBy="register")
	@JoinColumn(name="AdminId")
	private Admin Admin;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="register")
	@JoinColumn(name="custId")
    private Customer Customer;

    @Column(name = "date_of_register")
    private String dateOfRegister;

	    // Getters and setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getDateOfRegister() {
	        return dateOfRegister;
	    }

	    public void setDateOfRegister(String dateOfRegister) {
	        this.dateOfRegister = dateOfRegister;
	    }
	}