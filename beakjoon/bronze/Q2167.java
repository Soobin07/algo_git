package beakjoon.bronze;

import java.util.Scanner;

public class Q2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = sc.nextInt();
		int sum;
		for(int c = 0 ; c < cnt ; c++) {
			sum = 0;
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			for(int i2 = i ; i2 <= x ; i2++) {
				for(int j2 = j ; j2 <= y ; j2++) {
					sum += arr[i2][j2];
				}
			}
			System.out.println(sum);
		}
	}
}
