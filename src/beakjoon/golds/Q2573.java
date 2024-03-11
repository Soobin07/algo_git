package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//빙산
public class Q2573 {
	static int N, M;
	static int[][] map, group, tmp;
	static Queue<int[]> q;
	static Stack<int[]> s;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// 한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)
		// 다 녹을 때 까지 두 덩어리 이상 아니면 0 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		map = new int[N][M]; // 빙산 모양
		q = new LinkedList<>(); // 얼음 있는 곳 확인용
		s = new Stack<>(); // 얼음 나눠진 것 확인용

		// 맵 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		// 1년씩 지나가면서
		int year = 0; // 몇년 후?
		while (true) {
			// 빙산이 2개 이상으로 나뉘나?
			if (isTwo())
				break;
			// 더이상 빙산이 없나?
			if (q.isEmpty()) {
				year = 0;
				break;
			}

			// 안나뉘면 1년 더 간다
			year++;
			// 초기화
			tmp = new int[N][M]; // 올 해 지나가면 빙산 모양
			// 빙산 녹이자
			while (!q.isEmpty()) {
				int[] now = q.poll();
				// 상하좌우 0 갯수 확인
				int zero = 0;
				for (int k = 0; k < 4; k++) {
					int r = now[0] + dr[k];
					int c = now[1] + dc[k];
					// 맵 밖 확인
					if (r >= N || r < 0 || c >= M || c < 0)
						continue;
					if (map[r][c] == 0)
						zero++;
				}

				tmp[now[0]][now[1]] = Math.max(0, (map[now[0]][now[1]] - zero));
			}
			// 빙산 모양 바꿔주기 (올 해 것으로)
			map = tmp;
		}

		System.out.println(year);
	}

	// 빙산이 2개 이상으로 나뉘는지 확인하는 함수
	static boolean isTwo() {
		boolean[][] visit = new boolean[N][M];
		int cnt = 0;
		// 맵 전체를 돌아보면서 두개로 나뉘는지 확인하자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 이미 방문한 곳이면
				if (visit[i][j])
					continue;

				// visit 확인
				visit[i][j] = true;
				// 방문하지 않은 곳이면 (빙산 없으면 넘어가기)
				if (map[i][j] == 0)
					continue;
				// 새로운 빙산이다!!
				cnt++;
				// 초기화
				s.clear();
				q.clear();

				s.add(new int[] { i, j });
				q.add(new int[] { i, j });

				// 빙산 있으면 상하좌우 연결된 빙산 찾아서 모두 true로 변경
				while (!s.isEmpty()) {
					int[] now = s.pop();
					// 상하좌우 확인
					for (int k = 0; k < 4; k++) {
						int r = now[0] + dr[k];
						int c = now[1] + dc[k];

						// 맵 밖 확인
						if (r >= N || r < 0 || c >= M || c < 0)
							continue;
						// 이미 방문 확인
						if (visit[r][c])
							continue;
						// 빙산인지 확인
						if (map[r][c] == 0)
							continue;

						// 방문하자
						visit[r][c] = true;
						// 다음은 얘를 중심으로 옮겨보자
						s.add(new int[] { r, c });
						q.add(new int[] { r, c });
					}
				}
			}
		}
		if (cnt < 2)
			return false;
		return true;
	}
}
