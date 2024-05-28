package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불!
/*
 * BFS를 사용하였다.
 * 불과 지훈이를 2개의 while문으로 따로 이동시켰는데,
 * 지훈이 Q를 while 조건으로 두고 불,지훈이 Q를 따로 관리하였으면
 * 하나의 while문으로도 가능했을 것 같다.
 * 
 * 지훈이가 한명만 존재하고, 불은 여러개 존재할 수 있었는데
 * 불이 2개 이상인 것을 간과하여 여러번 틀렸다.
 * 또 불과 지훈이가 동시에 같은 곳에 도착하면 지훈이가 불에 타는 것을 간과하였다.
 */
public class Q4179 {
	static int R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// 초기 위치
		int[] jihun = new int[2];
		Queue<int[]> q = new LinkedList<>();
		int[][] fire_idx = new int[R][C];
		char[][] map = new char[R][C];
		int[][] jihun_idx = new int[R][C];

		// map입력받기
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'J') {
					jihun[0] = i;
					jihun[1] = j;
					jihun_idx[i][j] = 1;
				} else if (map[i][j] == 'F') {
					q.add(new int[] { i, j });
					fire_idx[i][j] = 1;
				}
			}
		}

		// 두번 간다. 불을 먼저 돌리고 지훈이 갈 수 있는 방향을 돌린다
		// 불
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int cost = fire_idx[now[0]][now[1]];
			// 4방향 돌아간다
			for (int d = 0; d < 4; d++) {
				// 4방향 위치
				int r = now[0] + dr[d];
				int c = now[1] + dc[d];

				// 맵을 벗어났나?
				if (r < 0 || r >= R || c < 0 || c >= C)
					continue;
				// 벽이 아닌가?
				if (map[r][c] == '#')
					continue;
				// 이미 간 곳인가?
				if (fire_idx[r][c] != 0)
					continue;

				// 넣어준다
				fire_idx[r][c] = cost + 1;
				q.add(new int[] { r, c });
			}
		}

		// 초기화
		q.clear();
		// 지훈이
		q.add(jihun);
		int ans = 1;
		boolean flag = canOut(jihun);
		if (!flag) {
			outer: while (!q.isEmpty()) {
				int[] now = q.poll();
				int cost = jihun_idx[now[0]][now[1]];
				// 4방향 돌아간다
				for (int d = 0; d < 4; d++) {
					// 4방향 위치
					int r = now[0] + dr[d];
					int c = now[1] + dc[d];

					// 맵을 벗어났나?
					if (r < 0 || r >= R || c < 0 || c >= C)
						continue;
					// 벽인가?
					if (map[r][c] == '#')
						continue;
					// 불이 이미 있나?
					if (fire_idx[r][c] > 0 && fire_idx[r][c] <= cost + 1)
						continue;
					// 이미 간 곳인가?
					if (jihun_idx[r][c] != 0)
						continue;

					int[] tmp = new int[] { r, c };
					// 나갈 수 있나?
					if (canOut(tmp)) {
						flag = true;
						ans = cost + 1;
						break outer;
					}
					// 몇 번째 돌았을 때 도착할 수 있는 칸인지 체크한다
					jihun_idx[r][c] = cost + 1;
					q.add(tmp);
				}
			}
		}

		// 답 출력
		if (flag) {
			System.out.println(ans);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	static boolean canOut(int[] arr) {
		// 가장자리면 나갈 수 있다
		if (arr[0] == 0 || arr[1] == 0 || arr[0] == R - 1 || arr[1] == C - 1)
			return true;
		return false;
	}
}
