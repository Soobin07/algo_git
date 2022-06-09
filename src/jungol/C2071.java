package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class C2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][n];
		
		if(m == 1) {
			for(int i = 0 ; i < n ; i++) {
				map[i][0] = 1;
				map[i][i] = 1;
			}
			for(int i = 2 ; i < n ; i++) {
				for(int j = 1 ; j < n ; j++) {
					map[i][j] = map[i-1][j-1] + map[i-1][j];   
				}
			}
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0; j < n ; j++) {
					if(map[i][j] != 0)
						System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}else if(m == 2) {
			for(int i = 0 ; i < n ; i++) {
				map[i][0] = 1;
				map[i][i] = 1;
			}
			for(int i = 2 ; i < n ; i++) {
				for(int j = 1 ; j < n ; j++) {
					map[i][j] = map[i-1][j-1] + map[i-1][j];   
				}
			}
			
			for(int i = n-1 ; i >= 0 ; i--) {
				for(int j = 0 ; j < n-1-i ; j++) {
					System.out.print(" ");
				}
				for(int j = n-1; j >= 0 ; j--) {
					if(map[i][j] != 0)
						System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}else if(m == 3) {
			
			for(int i = 0 ; i < n ; i++) {
				map[i][i] = 1;
			}
			Arrays.fill(map[n-1], 1);
			for(int i = n-3 ; i >= 0 ; i--) {
				for(int j = n-2 ; j >= 0 ; j--) {
					map[j][i] = map[j][i+1] + map[j+1][i+1];
				}
			}
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0; j < n ; j++) {
					if(map[i][j] != 0)
						System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		
	}
}
