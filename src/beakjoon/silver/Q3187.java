package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3187 {

	static int wolf = 0;
	static int sheep = 0;
	static char[][] map;
	static int[][] area;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		area = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int area_num = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (area[r][c] == 0 && map[r][c] != '#') {
					area[r][c] = ++area_num;
					bfs(r, c, area_num);
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	static void bfs(int r, int c, int area_num) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		int w = 0; // 임시, 늑대 cnt
		int s = 0; // 임시, 양 cnt

		if (map[r][c] == 'v')
			w++;
		else if (map[r][c] == 'k')
			s++;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				// 맵 밖
				if (nr >= R || nr < 0 || nc >= C || nc < 0)
					continue;

				// 이미 확인한 곳
				if (area[nr][nc] != 0)
					continue;

				// 맵에 무엇이 있는가
				char ch = map[nr][nc];
				// 울타리
				if (ch == '#')
					continue;
				else if (ch == 'v')
					w++;
				else if (ch == 'k')
					s++;

				area[nr][nc] = area_num;
				q.add(new int[] { nr, nc });
			}
		}

		if (w >= s) {
			wolf += w;
		} else {
			sheep += s;
		}
	}
}
