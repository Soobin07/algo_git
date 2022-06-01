package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] P = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
			P[i] = -1;
		}
		
		int[] C = Arrays.copyOf(A, N);
		Arrays.sort(C);
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(A[j] == C[i] && P[j] == -1) {
					P[j] = i;
					break;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < N ; i++) {
			sb.append(P[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
