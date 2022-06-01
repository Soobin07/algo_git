package beakjoon.silver;

import java.util.Scanner;

public class Q1010_2 {
	static int[][] comb = new int[30][30];
	public static void main(String[] args) {
		
		//조합공식대로 미리 조합 갯수 만들어놓기
		for(int i = 1 ; i < 30 ; i++) {
			comb[i][i] = 1;		//i개로 갈 수 있는데, 현재 i개를 세워야 해. 이때 선택할 수 있는 가지수
			comb[i][1] = i;		//i개를 선택할 수 있는데, 현재 1개만 세우면 돼. 이때 선택할 수 있는 가지수
		}
		for(int i = 2 ; i < 30 ; i++) {	//1은 했으니, 2부터
			for(int j = 2 ; j < 30 ; j++) {	//1은 했으니 2부터
				comb[i][j] = comb[i-1][j-1]+comb[i-1][j];	//이거 조합공식..
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(comb[M][N]);
		}
	}

	// 조합공식 사용
	static void com(int N, int M) {
		for(int i = 1 ; i < 30 ; i++) {
			comb[i][i] = 1;
			comb[i][1] = i;
		}
		for(int i = 2 ; i < 30 ; i++) {
			for(int j = 2 ; j < 30 ; j++) {
				comb[i][j] = comb[i-1][j-1]+comb[i-1][j];
			}
		}
	}
}
