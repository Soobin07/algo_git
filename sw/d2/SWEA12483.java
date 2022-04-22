package sw.d2;

import java.util.Scanner;

public class SWEA12483 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input12483.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] map;
		for(int t = 1 ; t <= T ; t++) {
			map = new int[10][10];
			int n = sc.nextInt();
			int count = 0;
			for(int i = 0 ; i < n ; i++) {
				//왼쪽 위 모서리 인덱스
				int r1 = sc.nextInt();
				int c1 = sc.nextInt();
				//오른쪽 아래 모서리 인덱스
				int r2 = sc.nextInt();
				int c2 = sc.nextInt();
				//색
				int color = sc.nextInt();
				
				for(int r = r1 ; r <= r2 ; r++) {
					for(int c = c1; c <= c2 ; c++) {
						if(map[r][c] != color && map[r][c] != 3) {
							map[r][c] += color;
						}
					}
				}
			}
			for(int i = 0 ; i < 10 ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					if(map[i][j] == 3) count++;
				}
			}
			System.out.printf("#%d %d%n",t, count);
		}
	}
}
