package com.onlinesareesshoppingsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.onlinesareesshoppingsystem.entities.Cashondelivery;

public class Cashondeliverydaoimpl implements Cashondeliverydao {

  public final EntityManager entityManager;

    public Cashondeliverydaoimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cashondelivery getCashOnDeliveryById(int codId) {
        return entityManager.find(Cashondelivery.class, codId);
    }

    @Override
    public void addCashOnDelivery(Cashondelivery cashOnDelivery) {
        entityManager.getTransaction().begin();
        entityManager.persist(cashOnDelivery);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCashOnDelivery(Cashondelivery cashOnDelivery) {
        entityManager.getTransaction().begin();
        entityManager.merge(cashOnDelivery);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCashOnDelivery(int codId) {
        Cashondelivery cashOnDelivery = getCashOnDeliveryById(codId);
        if (cashOnDelivery != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(cashOnDelivery);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<Cashondelivery> getAllCashOnDeliveries() {
        TypedQuery<Cashondelivery> query = entityManager.createQuery("SELECT c FROM Cashondelivery c", Cashondelivery.class);
        return query.getResultList();
    }

	@Override
	public void insert(Cashondelivery codobj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cashondelivery getcashondelivery(int codId, int mobNo, String status) {
		// TODO Auto-generated method stub
		return null;
	}
}
