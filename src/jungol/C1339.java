package jungol;

import java.util.Scanner;

public class C1339 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char alpha = 'A';
		int N = sc.nextInt();
		
		if(N % 2 == 0 || N < 1 || N > 100) {
			System.out.println("INPUT ERROR");
			return;
		}
		
		char[][] map = new char[N][N];
		
		for(int i = N/2 ; i >= 0 ; i--) {
			for(int j = i ; j < N-i ; j++) {
				map[j][i] = alpha++;
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
