package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PersonDao;
import com.dto.Person;

@Controller
public class Simple {

	@Autowired
	PersonDao dao;

	@RequestMapping(value = "/hello")
	public ModelAndView hlo() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Hello");
		model.addObject("msg", "Test Message");
		model.setViewName("hello");
		return model;
	}

	@RequestMapping(value = "/viewall")
	public ModelAndView viewall() {
		List<Person> list = dao.getAll();
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Hello");
		model.addObject("msg", "List Data");
		model.addObject("list", list);
		model.setViewName("viewall");
		return model;   
	}

/*	@RequestMapping("/viewall")
	public ModelAndView viewemp() {
		List<Person> list = dao.getAll();
		return new ModelAndView("viewall", "list", list);
	}*/

}
