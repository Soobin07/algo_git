package jungol;

import java.util.Scanner;

public class C1534 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(Integer.toUnsignedString(N, B).toUpperCase());
	}
}
