package com.test;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.Person;

public class Test1 {

	public static void main(String[] args) throws BeansException {
		
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("appcontext.xml");
			Person p = (Person) ctx.getBean("p1");
			p.disp();
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
