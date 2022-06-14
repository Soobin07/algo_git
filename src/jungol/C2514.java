package jungol;

import java.util.Scanner;

public class C2514 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int koi = 0;
		int ioi = 0;
		for(int i = 2 ; i < str.length() ; i++) {
			if(str.charAt(i)=='I' && str.charAt(i-1)=='O') {
				if(str.charAt(i-2)=='K') koi++;
				else if(str.charAt(i-2)=='I') ioi++;
			}
		}
		System.out.println(koi);
		System.out.println(ioi);
	}
}
