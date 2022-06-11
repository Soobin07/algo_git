package jungol;

import java.util.Scanner;

public class C1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String N = "0";
		int cnt = 0;
		while(cnt++ < 10 && !(N = sc.nextLine()).equals("0")) {
			sb.setLength(0);
			sb.append(N);
			while(sb.lastIndexOf("0") == sb.length()-1) sb.setLength(sb.length()-1);
			System.out.print(sb.reverse()+" ");
			int sum = 0;
			for(int i = 0 ; i < N.length() ; i++) {
				sum += N.charAt(i)-'0';
			}
			System.out.println(sum);
		}
		
	}
}
