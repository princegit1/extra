package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@RequestMapping(value = { "/", "", "/index" })
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		// String user = request.getParameter("user");
		ModelAndView model = new ModelAndView();
		/*
		 * if (user.equals("admin")) { model.addObject("testmsg", "Admin Message"); }
		 * else { model.addObject("testmsg", "Test Message"); }
		 */
		model.addObject("testmsg", "Test Message");
		model.setViewName("test");
		return model;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminP() {
		ModelAndView model = new ModelAndView();
		model.addObject("adminmsg", "Admin Message");
		model.setViewName("admin");
		return model;
	}

	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("index");

		return model;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		SecurityContextHolder.clearContext();

		if (session != null)
			session.invalidate();
		model.addObject("msg", "You've been logged out successfully.");   
		model.setViewName("index");    
      
		return model;

	}

}
