package com.onlinesareesshoppingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinesareesshoppingsystem.entities.Products;

public class Productsdaoimpl{
	 private Session session;

	 public Productsdaoimpl(Session session) {
	        this.session = session;
	    }
	public Productsdaoimpl() {
		// TODO Auto-generated constructor stub
	}
	public void insert(Products product) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();

			System.out.println(product);
			System.out.println("Record inserted into product table");		
		  } catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateProduct(int productid,String productname) {
		try {
			Products product = session.find(Products.class, productid);
			if (product == null)
				System.out.print("Record not found");
			else {
				product.setProductName(productname);
				product.setProductId(productid);
				Transaction tx = session.beginTransaction();
				session.merge(product);
				tx.commit();
				System.out.println(product);
				System.out.println("Record updated into product table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteProduct(int productId) {
		try
		{
	Products product = session.find(Products.class, productId);
	if (product == null)
		System.out.print("Record not found");
	else {
		Transaction tx = session.beginTransaction();
		session.remove(product);
		tx.commit();
		System.out.println(product);
		System.out.println("Record deleted from  product table");
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

	 public List<Products> select() {
	        List<Products> productList = null ;
	        try {
	           
	            if (session != null) {
	                productList = session.createQuery("FROM Products", Products.class).getResultList();
	            } else {
	                System.out.println("Session is null. Unable to execute query.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productList ;
	    }
	

	public void search(int productid) {
		try
		{
		 Products product = session.find(Products.class,productid);
		if (product == null)
			System.out.print("Record not found");
		else
			System.out.println(product);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void update(int productid, String productname) {
		// TODO Auto-generated method stub
		
	}

	

}
