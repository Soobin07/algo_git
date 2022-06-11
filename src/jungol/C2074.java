package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C2074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] map = new int[N][N];
		int num = 1;
		int[] now = {0, N/2};
		map[now[0]][now[1]] = num++;
		
		while(num <= N*N) {
			if((num - 1) % N == 0) {
				now = move(now, 1, 0, N);
			}else {
				now = move(now, -1, -1, N);
			}
			map[now[0]][now[1]] = num++;
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[] move(int[] now, int dr, int dc, int N) {
		int[] newDir = Arrays.copyOf(now, 2);
		if(newDir[0]+dr == N ) newDir[0] = 0;
		else if(newDir[0]+dr < 0) newDir[0] = N-1;
		else newDir[0] += dr;
		if(newDir[1]+dc == N ) newDir[1] = 0;
		else if(newDir[1]+dc < 0) newDir[1] = N-1;
		else newDir[1] += dc;
		return newDir; 
	}
}
