package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.employee.Employee;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Employee e1 = new Employee();
		System.out.println("Table is Created Successfully!!!");
		
		e1.setEmpName("Yash Patil");
		e1.setEmpAge(25);
		e1.setEmpSalary(150000);
		
		ss.persist(e1);
		tr.commit();
		ss.close();
		System.out.println("Data Added Successfully!!!");
	}

}
