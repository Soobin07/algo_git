package jungol;

import java.util.Scanner;

public class C2814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int result = 0;
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += (ch-'0')*Math.pow(2, str.length()-1-i);
		}
		System.out.println(result);
	}
}
