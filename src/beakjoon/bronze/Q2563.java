package beakjoon.bronze;

import java.util.Scanner;

public class Q2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[100][100];
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j = 0 ; j < 10 ; j++) {
				for(int k = 0 ; k < 10 ; k++ ) {
					map[y+j][x+k] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j]) count++;
			}
		}
		
		System.out.println(count);
	}
}
