package jungol;

import java.util.Scanner;

public class C1314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		char[][] map = new char[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i%2 == 0) {
					map[j][i] = (char)('A'+count);
				}else {
					map[N-1-j][i] = (char)('A'+count);
				}
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
