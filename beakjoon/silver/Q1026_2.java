package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q1026_2 {
	static String ex1 = "5\n" + 
			"1 1 1 6 0\n" + 
			"2 7 8 3 1";
	static String ex2 = "3\n" + 
			"1 1 3\n" + 
			"10 30 20";
	static String ex3 = "9\n" + 
			"5 15 100 31 39 0 0 3 26\n" + 
			"11 12 13 2 3 4 5 9 1";
	//큰값 * 작은값 = .. 최소값!
	public static void main(String[] args) {
		Scanner sc = new Scanner(ex1);
		int N = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		int[] order = new int[N];	

		//Array A와 B 넣기
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0 ; i < N ; i++) {
			B[i] = sc.nextInt();
		}
		for(int i = 0 ; i < N ; i++) {
			order[i] = i;
		}
		Arrays.sort(A);	//A 작은 순서대로 sort
		
		for(int i = 0 ; i < N-1 ; i++) {
			int maxIdx = i;
			for(int j = i+1 ; j < N ; j++) {
				if(B[order[maxIdx]] <= B[order[j]]) maxIdx = j;
			}
			int tmp = order[i];
			order[i] = order[maxIdx];
			order[maxIdx] = tmp;
		}
		
		int S = 0;
		for(int i = 0 ; i < N ; i++) {
			S += A[i]*B[order[i]];
		}
		
		System.out.println(S);
	}
}
