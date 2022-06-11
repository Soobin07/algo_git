package jungol;

import java.util.Scanner;

public class C1495 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int[] now = {0,0};
		
		int cnt = 1;
		int num = 1;
		
		map[now[0]][now[1]] = num++;
		while(cnt < N) {
			if(cnt % 2 == 0) {
				now[1]++;
			}else {
				now[0]++;
			}
			map[now[0]][now[1]] = num++;
			
			int dir = -1;
			if(cnt % 2 == 0) {
				dir *= -1;
			}
			for(int i = 0 ; i < cnt ; i++) {
				now[0] += dir;
				now[1] += (dir*-1);
				map[now[0]][now[1]] = num++;
			}
			cnt++;
		}
		cnt = N-1;
		while(cnt > 0) {
			if(cnt % 2 == 0) {
				now[1]++;
			}else {
				now[0]++;
			}
			map[now[0]][now[1]] = num++;
			int dir = 1;
			if(cnt % 2 == 0) {
				dir *= -1;
			}
			cnt--;
			for(int i = 0 ; i < cnt ; i++) {
				now[0] += dir;
				now[1] += dir*-1;
				map[now[0]][now[1]] = num++;
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
