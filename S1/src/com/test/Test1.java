package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.Person;

public class Test1 {
	public static void main(String ss[]) {
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("appContext.xml");
		Person p = (Person) ctx.getBean("a");    
        p.display();    				
	}

}
