package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

//정세한님 코드
public class SWEA1954_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/sw/input1954.txt"));
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			//현재 나의 좌표
			int r = 0;
			int c = 0;
			//우 하 좌 상 델타값(이동방향)
			int[] dr = {0,1,0,-1};
			int[] dc = {1,0,-1,0};
			
			int d = 0; //dr / dc의 0번 ==> 이동방향 우
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					arr[r][c] = i * N + j + 1;
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
						d = (d+1) % 4; //방향 전환
					}
					r += dr[d];
					c += dc[d];
				}
			}
			sb.append("#").append(t).append(" ").append("\n");
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
