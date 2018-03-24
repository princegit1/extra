package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AbcController {

	@RequestMapping(value = "/")
	public @ResponseBody String hello1() {
		return "hello ---------------> asdasd asda";
	}

	/*
	 * @RequestMapping(value = "/hello/{name}") public ModelAndView
	 * hlo(@PathVariable("name") String name) { ModelAndView model = new
	 * ModelAndView(); model.addObject("msg", "Test Object");
	 * model.addObject("name",name); model.setViewName("hello"); return model; }
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "index");
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/programme")
	public ModelAndView programme() {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "programme");
		model.setViewName("programme");
		return model;
	}

	@RequestMapping(value = "/speakers")
	public ModelAndView speakers() {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "speakers");
		model.setViewName("speakers");
		return model;
	}

	@RequestMapping(value = "/hello")
	public ModelAndView hlo1() {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "Test Object");

		model.setViewName("hello");
		return model;
	}
}
