package com.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.Test1;


public class Stest1 {
	public static void main(String ss[]) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		Test1 t = (Test1) ctx.getBean("aat");
		t.display();    
		
	}   

	
	
}
