package beakjoon.bronze;

import java.util.Scanner;

public class Q2669 {
	static String input1 = "1 2 4 4\r\n" + "2 3 5 7\r\n" + "3 1 6 5\r\n" + "7 3 8 6";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[101][101];

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int r = x1 ; r < x2 ; r++) {
				for(int c = y1 ; c < y2 ; c++) {
					map[r][c] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0 ; i < 101 ; i++) {
			for( int j = 0 ; j < 101 ; j++) {
				if(map[i][j]) count++;
			}
		}
		
		System.out.println(count);
	}
}
