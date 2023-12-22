package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10159 {

	// 물건의 개수, 미리 측정된 물건 쌍의 개수
	static int M, N;
	// 미리 측정된 물건 쌍의 관계도
	static int[][] arr;

	// 이 물건과 어떤 관계가 있는가
	static boolean[][] linked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		// 물건의 개수 (1~N까지 있음)
		N = Integer.parseInt(br.readLine());
		// 물건 두개가 어떻게 연결되어있나
		// -1 : 가볍다, 1 : 무겁다
		// [A][B] : A가 B보다 더 __ 하다
		arr = new int[N + 1][N + 1];
		linked = new boolean[N + 1][N + 1];

		// 물건 쌍의 개수
		M = Integer.parseInt(br.readLine());

		// 물건 무게 관계 연결하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gaind = Integer.parseInt(st.nextToken());
			int loss = Integer.parseInt(st.nextToken());
			arr[gaind][loss] = 1;
			arr[loss][gaind] = -1;
			linked[gaind][loss] = true;
		}

		// 각 물건을 시작점으로 연결하기
		for (int i = 1; i <= N; i++) {
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (linked[r][i] && linked[i][c]) {
						linked[r][c] = true;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if (!linked[i][j] && !linked[j][i]) {
					if (i == j)
						continue;
					cnt++;
				}
			}
			bw.append(cnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
