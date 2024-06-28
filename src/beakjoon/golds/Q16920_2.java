package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16920_2 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 조건
	static int N, M, P;
	// player가 한번에 갈 수 있는 범위
	static int[] go;
	// 플레이어 성 갯수
	static int[] castle;
	// 맵
	static char[][] map;
	// 상하좌우 위치
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// q
	static Queue<Node>[] q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 조건 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		// player가 한번에 갈 수 있는 범위 받기
		go = new int[P + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= P; i++) {
			go[i] = Integer.parseInt(st.nextToken());
		}

		castle = new int[P + 1];
		// 맵 받기
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 플레이어별 위치
		q = new Queue[P + 1];
		for (int i = 1; i <= P; i++)
			q[i] = new LinkedList<>();

		// 맵을 돌아 q에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= '0' && map[i][j] <= '9') {
					q[map[i][j] - '0'].add(new Node(i, j));
					castle[map[i][j] - '0']++;
				}
			}
		}

		// 몇번재 플레이어
		int player = 1;
		// 몇개의 성이 확장됨
		int expends = 0;

		while (true) {
			int cnt = game(player);
			castle[player] += cnt;
			expends += cnt;
			player++;

			if (player == P + 1) {
				if (expends == 0)
					break;
				expends = 0;
				player = 1;
			}
		}

		for (int i = 1; i <= P; i++) {
			System.out.print(castle[i] + " ");
		}
	}

	static int game(int player) {
		int cnt = 0;
		int dist = 1;
		Queue<Node> nq = q[player];
		while (!nq.isEmpty()) {
			int size = nq.size();
			for (int i = 0; i < size; i++) {
				Node now = nq.poll();
				for (int d = 0; d < 4; d++) {
					int r = now.r + dr[d];
					int c = now.c + dc[d];
					// 맵 벗어남
					if (r < 0 || c < 0 || r >= N || c >= M)
						continue;
					// 움직일 수 없음
					if (map[r][c] != '.')
						continue;

					nq.add(new Node(r, c));
					map[r][c] = (char) (player + '0');
					cnt++;
				}
			}
			dist++;
			if (dist > go[player])
				break;
		}
		return cnt;
	}
}
