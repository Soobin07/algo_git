package jungol;

import java.util.Scanner;

public class C1329 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		if(N <= 0 || N > 100 || N%2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(i <= N/2) {
				for(int j = 0 ; j < i ; j++) {
					sb.append(" ");
				}
				for(int j = 0 ; j < i*2+1 ; j++) {
					sb.append("*");
				}
				
			}else {
				for(int j = 0 ; j < N-1-i ; j++) {
					sb.append(" ");
				}
				for(int j = 0 ; j < (N-i)*2-1 ; j++) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
