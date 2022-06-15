package jungol;

import java.util.Scanner;

public class C2259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cost = sc.nextInt();
		int[][] map = new int[6][2];
		
		int maxX = -1;
		int maxY = -1;
		
		for(int i = 0 ; i < 6 ; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			
			if(map[i][0] <= 2) {
				if(maxX == -1 || map[maxX][1] < map[i][1]) {
					maxX = i;
				}
			}else if(map[i][0] >= 3){
				if(maxY == -1 ||map[maxY][1] < map[i][1]) {
					maxY = i;
				}
			}
		}//입력, 가장 큰 idx 구하기(가로/세로 각각)
		
		boolean[] visit = new boolean[6];
		visit[maxX] = true;
		visit[maxY] = true;
		int min = Math.min(maxX, maxY);
		int max = Math.max(maxX, maxY);
		if(min == 0 && max == 5) {
			visit[1] = visit[4] = true;
		}else {
			visit[(min+5)%6] = true;
			visit[(max+1)%6] = true;
		}

		//없어지는 x, y 값
		int minus = -1;
		for(int i = 0 ; i < 6 ; i++) {
			if(!visit[i]) minus *= map[i][1];
		}
		
		System.out.println((map[maxX][1]*map[maxY][1]+minus)*cost*1L);	
	}
}
