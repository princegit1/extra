package com.test;

interface A{
	void m1();
}
interface A2 extends A{
	void m2();
}
abstract class B{
	void m2() {
		System.out.println("---> m1B") ;
		
		
	}
}

class C  extends B implements A2{

	public void m1() {
		System.out.println("---> m1C1") ;
		
	}
	public void m2() {
		System.out.println("---> m1C2") ;
		try { int a=10/0; }catch(ArithmeticException e){System.out.println(e);}
		
		throw new ArithmeticException("Divide by zero");
		
	}
	
}
public class Test1 extends C {
	public void m1() {
		System.out.println("---> m1C1 Test1") ;
		
	}
	
	public static void main(String[] args) {
		Test1 a = new Test1();
		//Test1 t = (Test1) new C();
		System.out.println(a instanceof C);
		
		//t.m1();
		a.m2();
	}
	

}
