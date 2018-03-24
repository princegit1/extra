package com.test;



class SinglObj{
	private static SinglObj instance;
	private SinglObj() {}
	public static SinglObj getInstance() {
		if(instance==null) {
			instance = new SinglObj();
		}
		return instance;
	}
	
	public void dd() {
		System.out.println(" ---> sys ");
	}
}

public class SingletonTest {
	
	
	public static void main(String[] args) {
		SinglObj t = SinglObj.getInstance();
		t.dd();
	}
}
