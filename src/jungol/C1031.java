package jungol;

import java.util.Scanner;

public class C1031 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[5][5];
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				map[i][j] = sc.nextInt();
			}
		}//빙고판 만들기
		
		int bingo = 0;
		for(int i = 0 ; i < 25 ; i++) {
			int say = sc.nextInt();
			
			//맵에서 찾아서 0으로 바꾸기
			int r = -1;
			int c = -1;
			for(int j = 0 ; j < 5 ; j++) {
				for(int k = 0 ; k < 5 ; k++) {
					if(map[j][k] == say) {
						map[j][k] = 0;
						r = j;
						c = k;
					}
				}
			}
			
			//해당 줄의 가로, 세로 찾아보기
			boolean flag = true;
			for(int j = 0 ; j < 5 ; j++) {
				if(map[r][j] != 0) {
					flag = false;
					break;
				}
			}//가로 확인
			if(flag) bingo++;
			flag = true;
			for(int j = 0 ; j < 5 ; j++) {
				if(map[j][c] != 0) {
					flag = false;
					break;
				}
			}//세로 확인
			if(flag) bingo++;
			
			//대각선 가능한 경우 대각선
			if(r == c ) {
				flag = true;
				for(int j = 0 ; j < 5 ; j++) {
					if(map[j][j] != 0) {
						flag = false;
						break;
					}
				}
				if(flag) bingo++;
			}
			if(r + c == 4) {
				flag = true;
				for(int j = 0 ; j < 5 ; j++) {
					if(map[j][4-j] != 0) {
						flag = false;
						break;
					}
				}
				if(flag) bingo++;
			}
			
			if(bingo >= 3) {
				System.out.println(i+1);
				break;
			}
		}//부르기
	}
}
