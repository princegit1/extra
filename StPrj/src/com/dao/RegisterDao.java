package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dto.Person;

public class RegisterDao {

	public static int savePerson(Person p) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		int i = (Integer) session.save(t);
		t.commit();
		session.close();
		return i;
	}

}
