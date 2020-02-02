package com.star.sud.spring.orm.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.star.sud.spring.orm.dao.SmartPhonesDao;
import com.star.sud.spring.orm.model.TSmartPhones;

@Component
public class SmartPhonesService {

	@Autowired
	private SmartPhonesDao smartPhonesDao;

	@Transactional
	public void add(TSmartPhones product) {
		smartPhonesDao.persist(product);
	}

	@Transactional
	public void addAll(Collection<TSmartPhones> products) {
		for (TSmartPhones product : products) {
			smartPhonesDao.persist(product);
		}
	}

	@Transactional(readOnly = true)
	public List<TSmartPhones> listAll() {
		return smartPhonesDao.findAll();

	}

}
