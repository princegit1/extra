/**
 * 
 */
package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String ss[]) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		com.entity.Test t = (com.entity.Test) ctx.getBean("b1");
		t.displ();    

	}

}
