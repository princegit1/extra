package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dto.Person;

public class PersonDao {

	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public List<Person> getAll() {
		List<Person> list = new ArrayList<Person>();
		list = template.loadAll(Person.class);
		return list;
	}
}
