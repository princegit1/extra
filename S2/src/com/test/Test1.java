package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.Person;
import com.dto.Programme;
import com.dao.*;
public class Test1 {
	public static void main(String ss[]) {
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("appContext.xml");
		/*Person p = (Person) ctx.getBean("a");    
        p.display(); */
		
		ProgrammeDao p = (ProgrammeDao)ctx.getBean("pdao");
		List<Programme> li = p.getAllProgrammes();
		
		for(Programme pe:li) {
			System.out.println(pe);
		}
	}   

}
