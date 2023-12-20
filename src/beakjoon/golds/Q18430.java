package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18430 {
	// 나무판
	static int[][] board;
	// 나무 칸 사용 기록
	static boolean[][] visit;
	// 기본정보 (N : 세로, M : 가로)
	static int N, M;
	// 답
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N : 세로, M : 가로
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 나무판
		board = new int[N][M];
		// 방문 기록
		visit = new boolean[N][M];

		// 나무판 강도 입력
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				board[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		// 한칸씩 확인하며 돌기
		dfs(0, 0);

		// 답안 출력
		System.out.println(ans);
	}

	static void dfs(int nm, int sum) {
		if (nm == N * M) {
			ans = Math.max(ans, sum);
			return;
		}

		int n = nm / M;
		int m = nm % M;

		// 현재 칸이 사용되지 않았다면
		if (!visit[n][m]) {
			// 이 친구를 가운데로 아래 모양의 부메랑 만들기
			// ㄱ
			visit[n][m] = true;
			if (n + 1 < N && m - 1 >= 0 && !visit[n + 1][m] && !visit[n][m - 1]) {
				visit[n + 1][m] = true;
				visit[n][m - 1] = true;
				dfs(nm + 1, sum + board[n][m] * 2 + board[n + 1][m] + board[n][m - 1]);
				visit[n + 1][m] = false;
				visit[n][m - 1] = false;
			}
			// ㄱ의 좌우대칭
			if (n + 1 < N && m + 1 < M && !visit[n + 1][m] && !visit[n][m + 1]) {
				visit[n + 1][m] = true;
				visit[n][m + 1] = true;
				dfs(nm + 1, sum + board[n][m] * 2 + board[n + 1][m] + board[n][m + 1]);
				visit[n + 1][m] = false;
				visit[n][m + 1] = false;
			}
			// ㄴ
			if (n - 1 >= 0 && m + 1 < M && !visit[n - 1][m] && !visit[n][m + 1]) {
				visit[n - 1][m] = true;
				visit[n][m + 1] = true;
				dfs(nm + 1, sum + board[n][m] * 2 + board[n - 1][m] + board[n][m + 1]);
				visit[n - 1][m] = false;
				visit[n][m + 1] = false;
			}
			// ㄱ의 상하대칭
			if (n - 1 >= 0 && m - 1 >= 0 && !visit[n - 1][m] && !visit[n][m - 1]) {
				visit[n - 1][m] = true;
				visit[n][m - 1] = true;
				dfs(nm + 1, sum + board[n][m] * 2 + board[n - 1][m] + board[n][m - 1]);
				visit[n - 1][m] = false;
				visit[n][m - 1] = false;
			}
			visit[n][m] = false;
		}
		// 사용되었다면 다음 칸으로 넘어가기
		// 위의 네가지 다 보면 다음 칸으로 넘어가기
		dfs(nm + 1, sum);
	}
}
