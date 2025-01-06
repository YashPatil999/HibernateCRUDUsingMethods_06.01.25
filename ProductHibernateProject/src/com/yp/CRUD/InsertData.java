package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.product.Product;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Product p1 = new Product();
		System.out.println("Table is Created Successfully!!!");
		
		p1.setpName("Iphone 16 Pro");
		p1.setpQty(2);
		p1.setpCost(55000);
		
		ss.persist(p1);
		tr.commit();
		ss.close();
		System.out.println("Data Added Successfully!!!");
	}

}
