package jungol;

import java.util.Scanner;

public class C1880 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		char[] arr = sc.nextLine().toCharArray();
		String str = sc.nextLine();
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				sb.append((char)(arr[c-'A']-'a'+'A'));
			}
			else if(c == ' ') {
				sb.append(" ");
			}
			else {
				sb.append(arr[c-'a']);
			}
		}
		System.out.print(sb.toString());
	}
}
