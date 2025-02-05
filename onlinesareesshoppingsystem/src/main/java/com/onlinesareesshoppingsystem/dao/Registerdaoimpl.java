package com.onlinesareesshoppingsystem.dao;

import org.hibernate.Session;

import com.onlinesareesshoppingsystem.entities.Register;



public class Registerdaoimpl implements Registerdao {
    private Session session;

    public Registerdaoimpl(Session session) {
        this.session = session;
    }

    @Override
    public void insert(Register register) {
        try {
            session.beginTransaction();
            session.save(register);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

	
}
