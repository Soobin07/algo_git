package jungol;

import java.util.Scanner;

public class C1719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n > 0 && n <= 100 && n%2 == 1) {
			if(m == 1) {
				for(int i = 0 ; i < n ; i++) {
					if(i <= n/2) {
						for(int j = 0 ; j <= i ; j++) {
							sb.append("*");
						}
					}else {
						for(int j = 0 ; j <= n-1-i ; j++) {
							sb.append("*");
						}
					}
					sb.append("\n");
				}
			}else if(m == 2) {
				for(int i = 0 ; i < n ; i++) {
					if(i <= n/2) {
						for(int j = 0 ; j < n/2-i ; j++) {
							sb.append(" ");
						}
						for(int j = 0 ; j <= i ; j++) {
							sb.append("*");
						}
					}else {
						for(int j = 0 ; j < i-n/2 ; j++) {
							sb.append(" ");
						}
						for(int j = 0 ; j <= n-1-i ; j++) {
							sb.append("*");
						}
					}
					sb.append("\n");
				}
				
			}else if(m == 3) {
				for(int i = 0 ; i < n ; i++) {
					if(i <= n/2) {
						for(int j = 0 ; j < i ; j++) {
							sb.append(" ");
						}
						for(int j = 0 ; j < n-i*2 ; j++) {
							sb.append("*");
						}
					}else {
						for(int j = 0 ; j < n-1-i ; j++) {
							sb.append(" ");
						}
						for(int j = 0 ; j < (i-n/2)*2+1 ; j++) {
							sb.append("*");
						}
					}
					sb.append("\n");
				}
			}else if(m == 4) {
				for(int i = 0 ; i < n ; i++) {
					if(i <= n/2) {
						for(int j = 0 ; j < i ; j++) {
							sb.append(" ");
						}
						for(int j = 0 ; j <= n/2-i ; j++) {
							sb.append("*");
						}
					}else {
						for(int j = 0 ; j < n/2 ; j++) {
							sb.append(" ");
						}
						for(int j = 0; j <= i-n/2 ; j++) {
							sb.append("*");
						}
					}
					sb.append("\n");
				}
			}else {
				sb.append("INPUT ERROR!");
			}
		}else {
			sb.append("INPUT ERROR!");
		}
		System.out.print(sb);
	}
}
