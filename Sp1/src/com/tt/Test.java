package com.tt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appCont.xml");
		Dt1 t = (Dt1) context.getBean("aa");
		t.display();

	}

}
