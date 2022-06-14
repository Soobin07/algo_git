package jungol;

import java.util.Scanner;

public class C1671 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[101][101];
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for(int dr = 0 ; dr < 10 ; dr++) {
				for(int dc = 0 ; dc < 10; dc++) {
					map[r+dr][c+dc] = true;
				}
			}
		}
		
		int cnt = 0;
		//가로, 세로 방향으로 이전과 다른 값인 곳을 다 더해줌
		//가로
		for(int i = 0 ; i < 101 ; i++) {
			for(int j = 1 ; j < 101 ; j++) {
				if(map[i][j-1] != map[i][j]) cnt++;
			}
		}
		//세로
		for(int i = 1 ; i < 101 ; i++) {
			for(int j = 0 ; j < 101 ; j++) {
				if(map[i-1][j] != map[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
