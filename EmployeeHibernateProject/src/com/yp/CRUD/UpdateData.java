package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.employee.Employee;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int empid = 1;
		Employee e1 = ss.get(Employee.class, empid);
		e1.setEmpName("Girish");
		e1.setEmpAge(35);
		e1.setEmpSalary(60000);
		ss.merge(e1);
		tr.commit();
		ss.close();
		System.out.println("Data Updated Successfully!!!!");
	}
}
