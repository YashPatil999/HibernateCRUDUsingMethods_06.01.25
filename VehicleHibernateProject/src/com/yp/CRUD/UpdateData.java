package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.vehicle.Vehicle;

public class UpdateData {

public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int carSRno = 1;
		Vehicle v1 = ss.get(Vehicle.class, carSRno);
		v1.setCarMake("Suzuki");
		v1.setCarModel("Alto k10");
		v1.setCarManufacturingYear(2015);
		v1.setCarNumber("GJ 04 HG 7965");
		ss.merge(v1);
		tr.commit();
		ss.close();
		System.out.println("Data Updated Successfully!!!");
	}
}
