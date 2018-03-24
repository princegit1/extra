package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dto.Person;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class PersonDao {

	@SessionTarget
	Session session;
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		List<Person> list = new ArrayList<Person>();
		

		try {    
			list = session.createQuery("from Person").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



}
