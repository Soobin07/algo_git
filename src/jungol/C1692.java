package jungol;

import java.util.Scanner;

public class C1692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		int all = 0;
		
		for(int i = 0 ; i < second.length() ; i++) {
			int mult = second.charAt(second.length()-1-i)-'0';
			int cnt = 0;
			for(int j = 0 ; j < first.length() ; j++) {
				int scnd = first.charAt(first.length()-1-j)-'0';
				cnt += mult * scnd * Math.pow(10,j);
			}
			all += cnt*Math.pow(10, i);
			System.out.println(cnt);
		}
		System.out.println(all);
	}
}
