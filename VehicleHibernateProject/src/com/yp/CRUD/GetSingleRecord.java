package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.vehicle.Vehicle;

public class GetSingleRecord {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int carSRno = 1;
		Vehicle v1 = ss.get(Vehicle.class, carSRno);
		System.out.println(v1);
		tr.commit();
		ss.close();
	}
}
