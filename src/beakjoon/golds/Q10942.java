package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10942 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][N + 1];
		// 숫자 1개면 1임
		for (int i = 1; i <= N; i++) {
			dp[i][i] = 1;
		}
		// 숫자 2개면 두개 같으면 1임
		for (int i = 1; i <= N - 1; i++) {
			if (arr[i] == arr[i + 1])
				dp[i][i + 1] = 1;
		}
		// 끝점 i, 시작점 j
		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1)
					dp[j][j + i] = 1;
			}
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			bw.append(dp[S][E] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
