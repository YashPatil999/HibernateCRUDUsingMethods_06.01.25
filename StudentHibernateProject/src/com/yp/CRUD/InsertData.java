package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.student.Student;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Student s1 = new Student();
		System.out.println("Table is Added Successfully!!!");
		
		s1.setsName("Uemesh");
		s1.setsAge(19);
		s1.setsMarks(488);
		
		ss.persist(s1);
		tr.commit();
		ss.close();
		System.out.println("Data Added Successfully!!!");
	}

}
