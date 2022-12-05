package beakjoon.bronze;

import java.util.Scanner;

public class Q2511 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int[] A = new int[10];
		int[] B = new int[10];
		int sA = 0;
		int sB = 0;
		
		for(int i = 0 ; i < 10 ; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0 ; i < 10 ; i++) {
			B[i] = sc.nextInt();
		}
		
		char[] win = new char[10];
		for(int i = 0 ; i < 10 ; i++) {
			if(A[i] > B[i]) {
				sA += 3;
				win[i] = 'A';
			}else if(A[i] == B[i]) {
				sA += 1;
				sB += 1;
				win[i] = 'D';
			}else {
				sB += 3;
				win[i] = 'B';
			}
		}
		
		sb.append(sA+" "+sB+"\n");
		if(sA > sB) {
			sb.append("A");
		}else if(sA == sB) {
			boolean flag = false;
			for(int i = 0 ; i < 10 ; i++) {
				if(win[9-i] != 'D') {
					sb.append(win[9-i]);
					flag = true;
					break;
				}
			}
			if(!flag)
				sb.append('D');
		}else {
			sb.append("B");
		}
		
		System.out.println(sb.toString());
	}
}
