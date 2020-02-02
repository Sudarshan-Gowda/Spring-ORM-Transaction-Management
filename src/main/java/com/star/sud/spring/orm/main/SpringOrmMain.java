package com.star.sud.spring.orm.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.star.sud.spring.orm.model.TSmartPhones;
import com.star.sud.spring.orm.service.SmartPhonesService;

public class SpringOrmMain {

	public static void main(String[] args) {

		// Static Attributes
		//////////////////////
		Logger log = Logger.getLogger(SpringOrmMain.class);

		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		SmartPhonesService smartPhonesService = ctx.getBean(SmartPhonesService.class);

		try {

			smartPhonesService.add(new TSmartPhones(1, "One Plus", 45000.00));
			smartPhonesService.add(new TSmartPhones(2, "Samsung", 60000.00));

			List<TSmartPhones> list = new ArrayList<TSmartPhones>();
			list.add(new TSmartPhones(3, "I-Phone 10", 75000.00));
			list.add(new TSmartPhones(4, "HTC", 40000.00));

			// Adding Duplicate Primary Key to throw Exception
			list.add(new TSmartPhones(4, "Micro Max", 20000.00));

			// If any exception occurs means all data will be roll back - Since Transaction
			// annotation is enabled
			smartPhonesService.addAll(list);
		} catch (Exception e) {
			log.error("main", e);
		}

		System.out.println("listAll: " + smartPhonesService.listAll());
		ctx.close();

	}
}
