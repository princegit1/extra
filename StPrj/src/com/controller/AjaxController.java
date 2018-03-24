package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dto.Person;

public class AjaxController {
	private int a;
	private int b;
	Person p = new Person();
	List<Person> list = new ArrayList<Person>();
	private Map<String, Object> jsonData = new HashMap<String, Object>();

	public Map<String, Object> getJsonData() {
		return jsonData;
	}

	public void setJsonData(Map<String, Object> jsonData) {
		this.jsonData = jsonData;
	}

	public List<Person> getList() {
		return list;
	}

	public void setList(List<Person> list) {
		this.list = list;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String execute() {
		return "success";
	}

	public void hl() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("Hello World! " + new java.util.Date());
		out.flush();

	}

	public void sum() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter out = null;

		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("Sum " + (this.a + this.b));
		out.flush();

	}

	public String find() {
		jsonData.put("pd", new Person("aaa", "aaa@gmail.com", "1234", 3));
		return "success";

	}

	public String findall() {
		for (int i = 0; i < 1000; i++) {
			list.add(new Person("aaa" + i, "aaa" + i + "@gmail.com", "123" + i, i));
		}
		jsonData.put("pd", list);
		return "success";

	}

	public String listD() {
		Session session = null;
		Transaction t = null;
		List<Person> list = null;
		try {
			session = new Configuration().configure().buildSessionFactory().openSession();
			t = session.beginTransaction();
			String sql = "from P11";
			list = session.createQuery(sql).list();
			t.commit();
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "success";
	}

}
