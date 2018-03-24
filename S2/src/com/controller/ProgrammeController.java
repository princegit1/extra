package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ProgrammeDao;
import com.dto.Programme;
import com.dto.Speakers;

@Controller
public class ProgrammeController {
	@Autowired
	ProgrammeDao dao;

	@RequestMapping(value = "/viewall")
	public ModelAndView lstV() {
		List<Programme> list = dao.getAllProgrammes();
		return new ModelAndView("viewall", "list", list);

	}

	@RequestMapping(value = "/programme2")
	public ModelAndView lstV1() {
		ModelAndView model = new ModelAndView();
		List<Programme> list = dao.getAllProgrammes();
		List<Speakers> listsp = dao.getAllSpeakers();
		model.addObject("list", list);
		model.addObject("listsp", listsp);
		model.setViewName("programme2");
		return model;

	}
	
	
	@RequestMapping(value = "/editprog")
	public ModelAndView editprog() {
		ModelAndView model = new ModelAndView();
		List<Programme> list = dao.getAllProgrammes();
		List<Speakers> listsp = dao.getAllSpeakers();
		model.addObject("list", list);
		model.addObject("listsp", listsp);
		model.setViewName("editprog");   
		return model;

	}
	
	@RequestMapping(value = "/Updateprog")
	public ModelAndView Updateprog(@ModelAttribute("p") Programme p) {
		ModelAndView model = new ModelAndView();
		dao.update(p);   
/*		List<Programme> list = dao.getAllProgrammes();
		List<Speakers> listsp = dao.getAllSpeakers();
		model.addObject("list", list);
		model.addObject("listsp", listsp);*/
		model.setViewName("Updateprog");   
		return model;

	}
	
	
	
	
}
