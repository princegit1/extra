package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.PersonDao;
import com.dto.Person;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PersonController extends ActionSupport implements ModelDriven<Person> {

	Person person = new Person();
	List<Person> list = new ArrayList<Person>();
	PersonDao dao = new PersonDao();

	public PersonDao getDao() {
		return dao;
	}

	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	@Override
	public Person getModel() {
		return person;      
	} 

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getList() {
		return list;
	}

	
	public void setList(List<Person> list) {
		this.list = list;
	}

	public String listPerson() {
		System.out.println("Stttt ");
		list = dao.getAll();
		System.out.println("list: " +list);    
		return "success";     
	}



	
	
	
}
