package com.yp.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.book.Book;

public class UpdateData {

public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int bookid = 1;
		Book b1 = ss.get(Book.class, bookid);
		b1.setBookName("GameOfThrones");
		b1.setBookAuthor("Riche Rich");
		b1.setBookPrice(650);
		ss.merge(b1);
		tr.commit();
		ss.close();
		System.out.println("Data Updated Successfully!!!");

	}

}
