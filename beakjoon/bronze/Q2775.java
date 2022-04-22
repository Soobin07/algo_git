package beakjoon.bronze;

import java.util.Scanner;

public class Q2775 {
//	static String input1 = "2\n1\n3\n2\n3";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input1);
		int tc = sc.nextInt();
		int k, n;
		
		int[][] apt = new int[15][14];
		//아파트에 인수 넣기
		
		//0층
		for(int i = 0 ; i < 14 ; i++) {
			apt[0][i] = i+1;
		}
		//1호들
		for(int i = 1 ; i < 15 ; i++) {
			apt[i][0] = 1;
		}
		//1층~14층 (2호~14호)
		for(int i = 1 ; i < 15 ; i++) {
			for(int j = 1 ; j < 14 ; j++) {
				apt[i][j] = apt[i][j-1]+apt[i-1][j];
			}
		}
		//답안 출력
		for(int i = 0 ; i < tc ; i++) {
			k = sc.nextInt();
			n = sc.nextInt();
			System.out.println(apt[k][n-1]);
		}
	}
}
