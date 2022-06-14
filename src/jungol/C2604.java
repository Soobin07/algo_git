package jungol;

import java.util.Scanner;

public class C2604 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int height = 10;
		for(int i = 1 ; i < str.length() ; i++) {
			if(str.charAt(i-1) == str.charAt(i)) height += 5;
			else height += 10;
		}
		System.out.println(height);
	}
}
