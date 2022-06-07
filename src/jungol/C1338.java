package jungol;

import java.util.Scanner;

public class C1338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		char alpha = 'A';
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N-i ; j++) {
				map[i+j][N-1-j] = alpha++;
				if(alpha > 'Z') alpha = 'A';
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == '\u0000') System.out.print("  ");
				else System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
