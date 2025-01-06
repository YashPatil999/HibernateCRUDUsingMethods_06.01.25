package com.yp.CRUD;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yp.book.Book;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GetAllRecords {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		CriteriaBuilder hcb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<Book> root = cq.from(Book.class);
		cq.select(root);
		
		Query query = ss.createQuery(cq);
		List<Book> list = query.getResultList();
		
		Iterator<Book> iterator = list.iterator();
		
		 while (iterator.hasNext()) {
	            Book item = iterator.next();
	            System.out.println(item);
	        }
	}
}
