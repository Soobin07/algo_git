package jungol;

import java.util.Scanner;

public class C1707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		int write = 1;
		int[] now = new int[] {0,-1};
		int cnt = n;
		int flag = 1;
		while(true) {
			for(int i = 0 ; i < cnt ; i++) {
				now[1] += flag;
				map[now[0]][now[1]] = write++;
			}
			cnt--;
			if(cnt == 0) break;
			for(int i = 0 ; i < cnt ; i++) {
				now[0] += flag;
				map[now[0]][now[1]] = write++;
			}
			flag *= -1;
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
