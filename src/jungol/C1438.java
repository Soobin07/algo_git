package jungol;

import java.util.Scanner;

public class C1438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[101][101];
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int dr = sc.nextInt();
			int dc = sc.nextInt();
			for(int r = 0 ; r < 10 ; r++) {
				for(int c = 0 ; c < 10 ; c++) {
					map[dr+r][dc+c] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
