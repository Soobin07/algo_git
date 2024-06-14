package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//원판 돌리기
public class Q17822 {
	// 원판
	static int[][] wonpans;

	// 상하좌우 위치
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 원판 갯수, 숫자, 움직임
	static int N, M, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N개의 원판
		N = Integer.parseInt(st.nextToken());
		// M개의 숫자
		M = Integer.parseInt(st.nextToken());
		// T번 움직임
		T = Integer.parseInt(st.nextToken());

		// 원판들
		wonpans = new int[N + 1][M];
		// 숫자 넣기
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				wonpans[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// T번 움직임
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			// 원판 번호
			int wonpan = Integer.parseInt(st.nextToken());
			// 어느 방향으로?
			int dir = Integer.parseInt(st.nextToken());
			// 몇번?
			int times = Integer.parseInt(st.nextToken()) % M;

			// 옮기기
			for (int w = 1; wonpan * w <= N; w++) {
				int tmp = 0;
				for (int t = 0; t < times; t++) {
					if (dir == 0) {
						// 시계방향
						// 마지막 숫자
						tmp = wonpans[wonpan * w][M - 1];
						for (int i = M - 1; i > 0; i--) {
							wonpans[wonpan * w][i] = wonpans[wonpan * w][i - 1];
						}
						wonpans[wonpan * w][0] = tmp;
					} else {
						// 반시계방향
						// 넣을 마지막 숫자
						tmp = wonpans[wonpan * w][0];
						for (int i = 0; i < M - 1; i++) {
							wonpans[wonpan * w][i] = wonpans[wonpan * w][i + 1];
						}
						wonpans[wonpan * w][M - 1] = tmp;
					}
				}
			}

			// 없애야 하는 곳 확인
			boolean[][] visit = new boolean[N + 1][M];

			// 없앨 것이 있는가
			boolean flag = false;
			int sum = 0;
			int cnt = 0;
			// 전체 돌면서 상하좌우 같은 것 확인
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					// 0이면 이미 없어진 것 - 패스
					if (wonpans[i][j] == 0)
						continue;
					// 좌우 확인
					if (wonpans[i][j] == wonpans[i][(j + 1) % M]) {
						flag = true;
						visit[i][j] = true;
						visit[i][(j + 1) % M] = true;
					}
					// 상하 확인
					// 위쪽 확인 가능
					if (i > 1) {
						if (wonpans[i][j] == wonpans[i - 1][j]) {
							flag = true;
							visit[i][j] = true;
							visit[i - 1][j] = true;
						}
					}
					// 아래쪽 확인 가능
					if (i < N) {
						if (wonpans[i][j] == wonpans[i + 1][j]) {
							flag = true;
							visit[i][j] = true;
							visit[i + 1][j] = true;
						}
					}

					if (!flag && wonpans[i][j] > 0) {
						sum += wonpans[i][j];
						cnt++;
					}
				}
			}

			// 없앨 것 있으면 지우기
			if (flag) {
				for (int i = 1; i <= N; i++) {
					for (int j = 0; j < M; j++) {
						if (visit[i][j]) {
							wonpans[i][j] = 0;
						}
					}
				}
			} else {
				// 없으면 평균내서 빼기
				double avg = sum / (cnt * 1.0d);
				for (int i = 1; i <= N; i++) {
					for (int j = 0; j < M; j++) {
						if (wonpans[i][j] == 0)
							continue;
						if (avg > wonpans[i][j]) {
							wonpans[i][j]++;
						} else if (avg < wonpans[i][j]) {
							wonpans[i][j]--;
						}
					}
				}
			}
		}

		// 마지막 합
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				sum += wonpans[i][j];
			}
		}
		System.out.println(sum);
	}
}
