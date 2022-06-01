package beakjoon.silver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q1026 {
	static String ex1 = "5\r\n" + 
			"1 1 1 6 0\r\n" + 
			"2 7 8 3 1";
	static String ex2 = "3\r\n" + 
			"1 1 3\r\n" + 
			"10 30 20";
	static String ex3 = "9\r\n" + 
			"5 15 100 31 39 0 0 3 26\r\n" + 
			"11 12 13 2 3 4 5 9 1";
	//큰값 * 작은값 = .. 최소값?
	public static void main(String[] args) {
		Scanner sc = new Scanner(ex1);
		int N = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		Integer[] order = new Integer[N];	

		//Array A와 B 넣기
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0 ; i < N ; i++) {
			B[i] = sc.nextInt();
			order[i] = B[i];
		}
		Arrays.sort(A);	//A 작은 순서대로 sort
		Arrays.sort(order, Collections.reverseOrder());
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				
			}
		}
		
		int S = 0;
		for(int i = 0 ; i < N ; i++) {
			S += A[i]*order[i];
		}
		
		System.out.println(S);
	}
}
