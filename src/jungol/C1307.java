package jungol;

import java.util.Scanner;

public class C1307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		
		int count = 0;
		for(int i = N-1 ; i >= 0 ; i--) {
			for(int j = N-1 ; j >= 0 ; j--) {
				map[j][i] = (char)('A' + count);
				count = (count+1)%26;
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
