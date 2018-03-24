package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) throws IOException {
   
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Input : ");   
		String s11="";
		String s1 = br.readLine();
		//System.out.println(" --> " + s1);
		char[] ch = s1.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(Character.isLowerCase(ch[i])) {
				//System.out.println("YES " + Character.toUpperCase(ch[i]));
				s11+=Character.toUpperCase(ch[i]);
			}
			else   
			{    
				//System.out.println("NO " + Character.toLowerCase(ch[i]));
				s11+=Character.toLowerCase(ch[i]);
			}
			  
			
		}
		System.out.println("Final String :" + s11);

	}

}
