
package com.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test1 {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}

		Test1 t = new Test1();
		t.addData("ADDDDDeeeeDR");

		t.listData();

	}

	public Integer addData(String name) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer pid = null;
		try {
			tx = session.beginTransaction();
			Person person = new Person(name);
			pid = (Integer) session.save(person);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pid;
	}

	@SuppressWarnings("unchecked")
	public List<Person> listData() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Person> list = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery("from Person").list();
			/*
			 * for (Iterator<Person> itr = list.iterator(); itr.hasNext();) {
			 * Person person = itr.next(); System.out.println(person.getId() +
			 * " - " + person.getName()); }
			 */
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Person> listDataById(int id) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Person> list = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery("from Person where id=" + id).list();
			/*
			 * for (Iterator<Person> itr = list.iterator(); itr.hasNext();) {
			 * Person person = itr.next(); System.out.println(person.getId() +
			 * " - " + person.getName()); }
			 */
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public void delete(int id) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Person person = (Person) session.get(Person.class, id);
			session.delete(person);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	public void update(String name, int id) {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception E: " + e);
		}
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Person person = (Person) session.get(Person.class, id);
			person.setName(name);
			session.update(person);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

}
