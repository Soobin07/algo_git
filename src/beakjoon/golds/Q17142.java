package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//연구소
public class Q17142 {
	static int ans, N, M, blank;
	static int[] sel;
	static int[][] map;
	static ArrayList<int[]> virus;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ans = Integer.MAX_VALUE;

		sel = new int[M];
		map = new int[N][N];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
					map[i][j] = 0;
				} else if (map[i][j] == 1) {
					map[i][j] = -2;
				} else {
					map[i][j] = -1;
					blank++;
				}
			}
		}

		select(0, 0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);
	}

	// M개의 바이러스 선택하기
	static void select(int idx, int sel_idx) {
		if (sel_idx == M) {
			simul(copy_map());
			return;
		}
		if (idx >= virus.size()) {
			return;
		}

		sel[sel_idx] = idx;
		// 이번거 넣기
		select(idx + 1, sel_idx + 1);
		// 이번거 안넣기
		select(idx + 1, sel_idx);
	}

	static void simul(int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		int last = 1;
		int b = blank;
		for (int i = 0; i < M; i++) {
			int[] vir = virus.get(sel[i]);
			q.add(vir);
			map[vir[0]][vir[1]] = 1;
		}
		while (!q.isEmpty() && b != 0) {
			int[] now = q.poll();
			// 사방 확인
			for (int i = 0; i < 4; i++) {
				int[] next = { now[0] + dr[i], now[1] + dc[i] };
				// 사방이 맵 안임?
				if (next[0] >= N || next[0] < 0 || next[1] >= N || next[1] < 0)
					continue;
				// 가려는 곳에 벽 없음?
				// 이미 바이러스 활성화 된 곳임?
				if (map[next[0]][next[1]] == -2 || map[next[0]][next[1]] > 0)
					continue;

				// 새롭게 넣어주자
				if (map[next[0]][next[1]] == -1)
					b--;
				q.add(next);
				map[next[0]][next[1]] = map[now[0]][now[1]] + 1;
				if (last < map[next[0]][next[1]])
					last = map[next[0]][next[1]];
			}
		}
		if (isFull(map))
			ans = Math.min(ans, last - 1);
	}

	static int[][] copy_map() {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	static boolean isFull(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1)
					return false;
			}
		}
		return true;
	}
}
