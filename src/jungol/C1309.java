package jungol;

import java.util.Scanner;

public class C1309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(pack(n));
	}
	public static long pack(int n) {
		if(n == 1 ) {
			System.out.println("1! = 1");
			return 1;
		}
		System.out.println(n+"! = "+n+" * "+(n-1)+"!");
		return n * pack(n-1); 
	}
}
