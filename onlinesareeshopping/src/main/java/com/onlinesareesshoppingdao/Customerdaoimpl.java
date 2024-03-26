package com.onlinesareesshoppingdao;

import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.onlinesareesshopping.entities.Customer;

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
	         Customer employee = session.createQuery("from Employee where empEmail = :email and password = :password",Customer.class)
	                    .setParameter("email", email)
	                    .setParameter("password", password)
	                    .getSingleResult();

	            return employee;

	        } catch (NoResultException e) {
	            // Handle case where no employee is found
	            return null;
	        }
			    }
			}

		

		
		

