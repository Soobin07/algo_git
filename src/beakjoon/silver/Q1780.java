package beakjoon.silver;

import java.util.Scanner;

public class Q1780 {
	static int N, minus, zero, one;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}//입력 종료
		
		getNumber(0, 0, N);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	
	static void getNumber(int r, int c, int intv) {
		int result = 2;
		if(intv != 1)
			result = check(r, c, intv);
		else
			result = map[r][c];
		if(result == 2) {
			for(int i = r ; i < r+intv ; i+=intv/3) {
				for(int j = c ; j < c+intv ; j+=intv/3) {
					getNumber(i, j, intv/3);
				}
			}
		}else if(result == -1) {
			minus++;
		}else if(result == 0) {
			zero++;
		}else if(result == 1) {
			one++;
		}
	}
	
	static int check(int r, int c, int intv) {
		int stnd = map[r][c];
		for(int i = r ; i < r+intv ; i++) {
			for(int j = c ; j < c+intv ; j++) {
				if(stnd != map[i][j]) return 2;
			}
		}
		return stnd;
	}
}
