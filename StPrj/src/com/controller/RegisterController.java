package com.controller;

import com.dao.RegisterDao;
import com.dto.Person;

public class RegisterController {
	Person p = new Person();

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public String execute() {
		RegisterDao.savePerson(p);
		return "success";
	}

}
