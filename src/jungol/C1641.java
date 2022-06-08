package jungol;

import java.util.Scanner;

public class C1641 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n <= 0 || n > 100 || n%2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		if(m == 1) {
			int cnt = 1;
			for(int i = 0 ; i < n ; i++) {
				if(i%2 == 0) {
					for(int j = 0 ; j <= i ; j++) {
						sb.append(cnt++ +" ");
					}
				}else {
					cnt += i;
					for(int j = 0 ; j <= i ; j++) {
						sb.append(cnt--+" ");
					}
					cnt += i+2;
				}
				sb.append("\n");
			}
		}else if(m == 2) {
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < i ; j++) {
					sb.append("  ");
				}
				for(int j = n*2-1 ; j > i*2 ; j--) {
					sb.append(i+" ");
				}
				sb.append("\n");
			}
		}else if(m == 3) {
			for(int i = 0 ; i < n ; i++) {
				if(n/2 >= i) {
					for(int j = 1 ; j <= i+1 ; j++) {
						sb.append(j+" ");
					}
				}else {
					for(int j = 1 ; j <= n-i ; j++) {
						sb.append(j+" ");
					}
				}
				sb.append("\n");
			}
		}else {
			sb.append("INPUT ERROR!");
		}
		System.out.print(sb);
	}
}
