package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.vehicle.Vehicle;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Vehicle v1 = new Vehicle();
		System.out.println("Table is Created Successfully!!!");
		
		v1.setCarNumber("AN 01 Z 0123");
		v1.setCarMake("Tata");
		v1.setCarModel("Nexon");
		v1.setCarManufacturingYear(2018);
		
		ss.persist(v1);
		tr.commit();
		ss.close();
		System.out.println("Data Added Successfully!!!");
	}
}
