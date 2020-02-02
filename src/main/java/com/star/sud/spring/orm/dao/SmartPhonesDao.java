package com.star.sud.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.star.sud.spring.orm.model.TSmartPhones;

@Component
public class SmartPhonesDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(TSmartPhones product) {
		em.persist(product);
	}

	@SuppressWarnings("unchecked")
	public List<TSmartPhones> findAll() {
		return em.createQuery("SELECT o FROM TSmartPhones o").getResultList();
	}

}
