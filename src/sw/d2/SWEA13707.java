package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//1. map을 2차원 배열로 입력 받자
//2. 전체를 순회(행우선 / 열 우선 상관X)
//3. 만약 기지국을 만난다면 (A or B or C) or (H, X가 아니면)
//   if(a일 때 => 사방향, b일 때=> 사방향*2, c일 때=> 사방향*3..) 
//4. 탐색하다 집을 만나면 집을 X로 바꾼다. or 집을 센 후 커버되는 집의 갯수를 마이너스

public class SWEA13707 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input13707.txt"));
		Scanner sc = new Scanner(System.in);
		
//		int[][] d1 = {{-1,0},{1,0},{0,-1},{0,1}};
//		int[][] d2 = {{-1,0},{-2,0},{1,0},{2,0},{0,-1},{0,-2},{0,1},{0,2}};
//		int[][] d3 = {{-1,0},{-2,0},{-3,0},{1,0},{2,0},{3,0},{0,-1},{0,-2},{0,-3},{0,1},{0,2},{0,3}};
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T ; t++) {
			//카운트 초기화
			int count = 0; 
			
			int n = Integer.parseInt(sc.nextLine());
			char[][] map = new char[n][n];
			
			//map 값 넣기
			for(int i = 0 ; i < n ; i++) {
				String tmp = sc.nextLine();
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}

			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0; j < n ; j++) {	//(시작점)기지국 찾기
					char ch = map[i][j];
					
//					int[][] d = null;
//					if(ch == 'A') {
//						d = d1;
//					}else if(ch == 'B') {
//						d = d2;
//					}else if(ch == 'C') {
//						d = d3;
//					}
//					
//					if(d != null) {
//						for(int k = 0 ; k < d.length ; k++) {
//							if(i+d[k][0] >= 0 && i+d[k][0] < n 
//									&& j+d[k][1] >= 0 && j+d[k][1] <n 
//									&& map[i+d[k][0]][j+d[k][1]] == 'H') {
//								map[i+d[k][0]][j+d[k][1]] = 'O';
//							}
//						}
//					}
					
					int k = 0;
					if(ch == 'A') {
						k = 1;
					}else if(ch == 'B') {
						k = 2;
					}else if(ch == 'C') {
						k = 3;
					}
					
					for(int idx = 1 ; idx <= k ; idx++) {
						//상
						if(i-idx >= 0 && map[i-idx][j] == 'H') {
							map[i-idx][j] = 'O';
						}
						//하
						if(i+idx < n && map[i+idx][j] == 'H') {
							map[i+idx][j] = 'O';
						}
						//좌
						if(j-idx >= 0 && map[i][j-idx] == 'H') {
							map[i][j-idx] = 'O';
						}
						//우
						if(j+idx < n && map[i][j+idx] == 'H') {
							map[i][j+idx] = 'O';
						}
					}
				}
			}
			
			//H 찾기
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(map[i][j] == 'H') count++;
				}
			}
			
			System.out.printf("#%d %d\n", t, count);
		}
	}
}
