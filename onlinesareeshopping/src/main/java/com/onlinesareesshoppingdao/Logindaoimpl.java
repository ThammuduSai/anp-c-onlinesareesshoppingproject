package com.onlinesareesshoppingdao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.onlinesareesshopping.entities.Login;


public  class Logindaoimpl implements Logindao {

    private Session session;

    public Logindaoimpl(Session session) {
        this.session = session;
    }

    @Override
    public Login getLoginById(int loginId) {
        try {
            Login login = session.find(Login.class, loginId);
            if (login == null)
                System.out.println("Record not found");
            else
                System.out.println(login);
            return login;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateLogin(int loginid,String email,String password) {
    	try {
			Login login = session.find(Login.class, loginid);
			if (login == null)
				System.out.print("Record not found");
			else {
			 
			login.setEmail(email);
			login.setLoginId(loginid);
			login.setPassword(password);
				Transaction tx = session.beginTransaction();
				session.merge(login);
				tx.commit();
				System.out.println(login);
				System.out.println("Record updated into login table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
