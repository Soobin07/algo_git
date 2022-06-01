package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1209 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1209.txt"));
		Scanner sc= new Scanner(System.in);
		
		int T = 10; //테스트 케이스
		
		for(int t = 1 ; t <= T ; t++) {
			int tc = sc.nextInt();
			
			//맵 작성
			int[][] map = new int[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//sum의 최댓값 찾기
			int max_sum = Integer.MIN_VALUE;
			//1. 행
			for(int i = 0 ; i < 100 ; i++) {
				int sum = 0;
				for(int j = 0 ; j < 100 ; j++) {
					sum += map[i][j];
				}
				if(max_sum < sum) max_sum = sum;
			}
			//2. 열
			for(int j = 0 ; j < 100 ; j++) {
				int sum = 0;
				for(int i = 0 ; i < 100 ; i++) {
					sum += map[i][j];
				}
				if(max_sum < sum) max_sum = sum;
			}
			//3. 대각선
			for(int i = 0 ; i < 100 ; i++) {
				int sum=map[i][i];
				if(max_sum < sum) max_sum = sum;
			}
			//4. 대각선 2
			for(int i = 0 ; i < 100 ; i++) {
				int sum=map[i][99-i];
				if(max_sum < sum) max_sum = sum;
			}
			
			System.out.printf("#%d %d%n", tc, max_sum);
		}
	}
}
