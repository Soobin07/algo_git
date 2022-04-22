package beakjoon.subclass;

import java.util.Scanner;

public class Q10163 {
	static String input1 = "2\n" + 
			"0 0 10 10\n" + 
			"2 2 6 6";
	static String input2 = "3\n" + 
			"0 2 10 10\n" + 
			"7 9 8 4\n" + 
			"8 4 10 6";
	static String input3 = "4\n" + 
			"0 2 10 10\n" + 
			"7 9 8 4\n" + 
			"8 4 10 6\n" + 
			"6 0 12 10";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(input2);
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int[][] map = new int[1001][1001];
		int[] count = new int[N+1];
		
		//색종이 놓기
		for(int n = 1 ; n <= N ; n++) {
			int x = sc.nextInt();	//x좌표
			int y = sc.nextInt();	//y좌표
			int w = sc.nextInt();	//width
			int h = sc.nextInt();	//height
			
			for(int i = 0 ; i < w ; i++) {	//가로 돌리기
				for(int j = 0 ; j < h ; j++) {	//세로 돌리기
					if(map[y+j][x+i] == 0) {	//x좌표 = col //y좌표 = row
						map[y+j][x+i] = n;
					}else {
						count[map[y+j][x+i]]--;	//n이 덮어졌으니 빼기
						map[y+j][x+i] = n;
					}
					count[n]++;		//n이 보이는 위치 카운트
				}
			}
		}
		
		//색종이 확인
		int cnt = 0;
		for(int i = 1 ; i <= N ; i++) {
			System.out.println(count[i]);
		}
	}
}
