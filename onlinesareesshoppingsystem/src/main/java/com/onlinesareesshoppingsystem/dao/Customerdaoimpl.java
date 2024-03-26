package com.onlinesareesshoppingsystem.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinesareesshoppingsystem.entities.Customer;

public class Customerdaoimpl  implements Customerdao{
	private Session session;
	public Customerdaoimpl(Session session)
	{
		this.session=session;
	}

		public void insert(Customer customer) {
			try {
				Transaction tx = session.beginTransaction();
				session.save(customer);
				tx.commit();

				System.out.println(customer);
				System.out.println("Record inserted into customer table");		
			  } catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public Customer getCustomerByEmailAndPassword(String email, String password) {
			  try {
		            String hql = "FROM Customer WHERE custEmail = :email AND password = :password"; // Use 'custEmail' instead of 'email'
		            TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		            query.setParameter("email", email);
		            query.setParameter("password", password);
		            return query.getSingleResult();
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		}
			}

		

		
		

