package beakjoon.silver;

import java.util.Scanner;

public class Q2527 {
	static String input1 = "3 10 50 60 100 100 200 300\r\n" + 
			"45 50 600 600 400 450 500 543\r\n" + 
			"11 120 120 230 50 40 60 440\r\n" + 
			"35 56 67 90 67 80 500 600";
	static String input2 = "30 10 50 60 50 80 80 100";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(input2);
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		for(int n = 0 ; n < 4 ; n++) {
			int[][] dir = new int[2][4];		//좌표 (x, y, p, q)
			int[][] val = new int[2][2];	//r, c 좌표의 최소 / 최대값

			char ans = 'd';	//얼마나 겹치는지
			
			//점 넣기
			for(int i = 0 ; i < 2 ; i++) {
				for(int j = 0 ; j < 4 ; j++) {
					dir[i][j] = sc.nextInt();
				}
			}
			
			//최소 / 최대값 초기화
			for(int i = 0 ; i < 2 ; i++) {
				val[0][i] = Integer.MAX_VALUE;
				val[1][i] = Integer.MIN_VALUE;
			}
			
			//최소 / 최대값 구하기
			//x의 최소
			val[0][0] = Math.min(dir[0][0], dir[1][0]);
			//y의 최소
			val[0][1] = Math.min(dir[0][1], dir[1][1]);
			//p의 최대
			val[1][0] = Math.max(dir[0][2], dir[1][2]);
			//q의 최대
			val[1][1] = Math.max(dir[0][3], dir[1][3]);
			
			
			int plus = dir[0][2]-dir[0][0] + dir[1][2]-dir[1][0];
			int map = val[1][0]-val[0][0];
			if(plus < map) {	//가로 안붙음
				ans = 'd';
			}else if(plus == map) {	//가로 딱 맞음
				ans = 'c'; //선 또는 점 (아래도 똑같으면 점, 아래는 겹치면 선)
			}else {	//가로 겹침
				ans = 'b'; //선 또는 직사각형 (아래도 맵이 작으면 직사각형, 아래는 딱 맞으면 선)
			}
			plus = dir[0][3]-dir[0][1] + dir[1][3]-dir[1][1];
			map = val[1][1]-val[0][1];
			if(plus < map) {	//세로 안붙음
				ans = 'd';
			}else if(plus > map) {
				if(ans == 'c') ans = 'b';
				else if(ans == 'b') ans = 'a';
//			}else if(plus == map) {	//세로 딱 맞음
//				if(ans == 'c') ans = 'c';
//				else if(ans == 'b') ans = 'b';
			}
			System.out.println(ans);
		}
	}
}
