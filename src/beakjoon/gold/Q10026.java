package beakjoon.gold;

import java.util.Scanner;

public class Q10026 {

	static int N, ans1, ans2; // 1:정상, 2:적록색약
	static char[][] map;
	static boolean[][] visit1, visit2; // 1:정상, 2:적록색약

	// 백터, 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		} // map 저장

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { // 시작점 찾기
				if (!visit1[i][j]) {
					ans1++;
					find1(i, j, map[i][j]);
				}
				if (!visit2[i][j]) {
					ans2++;
					find2(i, j, map[i][j]);
				}
			}
		}
		
		System.out.printf("%d %d", ans1, ans2);
	}

	// 정상
	static void find1(int r, int c, char color) {
		visit1[r][c] = true;
		for(int i = 0 ; i < 4 ; i++) {	//4방탐색
			//인덱스확인
			if(r+dr[i] >= 0 && r+dr[i] < N && c+dc[i] >= 0 && c+dc[i] < N) { //인덱스 안에 들어오면
				if(!visit1[r+dr[i]][c+dc[i]] && map[r+dr[i]][c+dc[i]]==color) {//안가봤고, color가 같으면 같은 구역
					find1(r+dr[i], c+dc[i], color);
				}
			}
		}
	}
	// 색약
	static void find2(int r, int c, char color) {
		visit2[r][c] = true;
		for(int i = 0 ; i < 4 ; i++) {	//4방탐색
			//인덱스확인
			if(r+dr[i] >= 0 && r+dr[i] < N && c+dc[i] >= 0 && c+dc[i] < N) { //인덱스 안에 들어오면
				if(!visit2[r+dr[i]][c+dc[i]]) {//안가봤고
					if(color == 'B'  && map[r+dr[i]][c+dc[i]]==color) {// color가 같으면 같은 구역
						find2(r+dr[i], c+dc[i], color);
					}else if(color != 'B' && (map[r+dr[i]][c+dc[i]]=='G' || map[r+dr[i]][c+dc[i]]=='R')) {
						find2(r+dr[i], c+dc[i], color);
					}
				}
			}
		}
	}
}
