package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	static void inputArr(int rows, int column, int a[][], BufferedReader br) throws NumberFormatException, IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("Enter input for [" + i + "" + j + "] = ");
				a[i][j] = Integer.parseInt(br.readLine());
			}
			System.out.println(" ");
		}
	}

	static void printArr(int rows, int column,int a[][],BufferedReader br) throws NumberFormatException, IOException {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(" [" + i + "" + j + "] = " + a[i][j] + " \t ");
			}
			System.out.println(" ");
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int r, c;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Row: ");
		r = Integer.parseInt(br.readLine());
		System.out.println("Enter Column: ");
		c = Integer.parseInt(br.readLine());
		System.out.println("Row is: " + r + " and column is: " + c);
		int a[][] = new int[r][c];
		inputArr(r, c, a, br);
        
		printArr(r, c, a, br);
		

	}

}
