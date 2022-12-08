package beakjoon.silver;

import java.util.Scanner;

public class Q2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		boolean[][] map = new boolean[c][r];
		
		int cnt = sc.nextInt();
		for(int i = 0 ; i < cnt ; i++) {
			if(sc.nextInt() == 0) {
				int tmp = sc.nextInt();
				for(int j = 0 ; j < map[tmp].length ; j++) {
					map[tmp][j] = true;
				}
			}else {
				int tmp = sc.nextInt();
				for(int j = 0 ; j < map.length ; j++) {
					map[j][tmp] = true;
				}
			}
		}
		
		int largeR = 0;
		int largeC = 0;
		for(int i = 0 ; i < map.length ; i++) {
			int con = 0;
			for(int j = 0 ; j < map[i].length ; j++) {
				if(map[i][j] == true) {
					if(largeR < con)
						largeR = con;
					con = 1;
				}else {
					con++;
				}
			}
			if(largeR < con)
				largeR = con;
		}
		for(int i = 0 ; i < map[0].length ; i++) {
			int con = 0;
			for(int j = 0 ; j < map.length ; j++) {
				if(map[j][i] == true) {
					if(largeC < con)
						largeC = con;
					con = 1;
				}else {
					con++;
				}
			}
			if(largeC < con)
				largeC = con;
		}
		
		System.out.println(largeR*largeC);
	}
}
