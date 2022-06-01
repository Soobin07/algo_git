package codeup;

import java.util.Scanner;

public class C1920 {
	static int count = 0;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 0 ) sb.append("0");
		else mul(n);
		System.out.println(sb.toString());
	}
	
	static void mul(int x) {
		if(x != 0) {
			mul((x-x%2)/2);
			sb.append(x%2);
		}
	}
}
