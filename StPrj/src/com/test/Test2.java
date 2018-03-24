package com.test;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dto.Person;

public class Test2 {

	public static void addp(String name,String email, String password, int id) {
		Session session = null;
		Transaction t = null;
		List<Person> list = null;
		try {
			session = new Configuration().configure().buildSessionFactory().openSession();
			t = session.beginTransaction();
			Person p1 = new Person(name, email, password, id);
			session.save(p1);
			/*String sql = "from P11";
			list = session.createQuery(sql).list();*/
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	public void finalize() {
		System.out.println("Finalize");
	}
	
	public static void main(String[] args) {
	for(int i=1;i<100;i++) {	
     addp("aaa"+i, "aaa"+i+"@gmail.com", "123"+i, i);
	}    
	
	
	
/*		Test2 t = new Test2();
		t = null;
		  
		System.gc();*/
		
	}

}  
