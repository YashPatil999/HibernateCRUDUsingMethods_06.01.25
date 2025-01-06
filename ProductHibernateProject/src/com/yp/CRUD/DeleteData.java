package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.product.Product;

public class DeleteData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int pid = 2;
		Product p1 = ss.get(Product.class, pid);
		ss.remove(p1);
		tr.commit();
		ss.close();
		System.out.println("Data Deleted Successfully!!!");
	}

}
