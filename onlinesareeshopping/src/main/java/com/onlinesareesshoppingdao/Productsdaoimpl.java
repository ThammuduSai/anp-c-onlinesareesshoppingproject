package com.onlinesareesshoppingdao;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.onlinesareesshopping.entities.Products;

public class Productsdaoimpl implements Productdao{
	 public Session session;

	    public Productsdaoimpl(Session session) {
	        this.session = session;
	    }
	public void  insert(Products product) {
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

	@Override
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

	@Override
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

	@Override
	public List<Products> select() {
		Transaction tx = session.beginTransaction();
		Query qobj = session.createQuery("select all Products");
		@SuppressWarnings("unchecked")
		List<Products> list = (List<Products>) qobj.getResultList();
		tx.commit();
		return list;
	}

	@Override
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
	
}
