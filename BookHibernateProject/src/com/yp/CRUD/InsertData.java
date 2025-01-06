package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.book.Book;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Book b1 = new Book();
		System.out.println("Table is created Successfully!!!");
		
		b1.setBookName("Middle of the Night");
		b1.setBookAuthor("Riley Sager");
		b1.setBookPrice(900);
		
		ss.persist(b1);
		System.out.println(b1);
		tr.commit();
		ss.clear();
		System.out.println("Data Added Successfully!!!!");
		
	}

}
