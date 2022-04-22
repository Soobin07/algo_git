package beakjoon.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14503 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(r, c, d);
		
		System.out.println(ans);
	}

	static void go(int r, int c, int d) {
		if(!visited[r][c]) ans++;
		visited[r][c] = true;
		
		int nd = d;
		for (int i = 0; i < 4; i++) {
			nd = (d+3-i) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(map[nr][nc] == 0 && !visited[nr][nc]) {
				go(nr,nc,nd);
				return;
			}
		}
		nd = (d+2)%4;
		int nr = r+dr[nd];
		int nc = c+dc[nd];
		if(map[nr][nc] == 1) {
			return;
		}else {
			go(nr,nc,d);
		}
	}
}
