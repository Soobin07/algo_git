package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//진우의 달 여행
public class Q17484 {
	static int N, M;
	static int[][] map, sum;
	static int[] dc = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		// 소모 연료 양 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sum = new int[N][M];
		// 전체 숫자를 최대로 올린다
		for (int i = 0; i < N; i++) {
			Arrays.fill(sum[i], Integer.MAX_VALUE);
		}

		// 첫 줄과 시작점 넣기
		Queue<int[]> go = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			sum[0][i] = map[0][i];
			go.add(new int[] { -1, 0, i, sum[0][i] });
		}
		// bfs 느낌으로 돌아보기
		while (!go.isEmpty()) {
			// 현재 위치
			int[] now = go.poll();

			// 가장 아래줄에 도착하면 멈춘다
			if (now[1] == N - 1)
				continue;

			for (int i = 0; i < 3; i++) {
				// 이전과 다른 방향으로 간다
				if (i == now[0])
					continue;

				int r = now[1];
				int c = now[2];

				// 맵 나가는지 확인
				if (c + dc[i] >= M || c + dc[i] < 0)
					continue;
				// 둘 중 더 작은 것 넣기
				sum[r + 1][c + dc[i]] = Math.min(sum[r + 1][c + dc[i]], now[3] + map[r + 1][c + dc[i]]);

				// 다음 칸 가기
				go.add(new int[] { i, r + 1, c + dc[i], now[3] + map[r + 1][c + dc[i]] });
			}

		}

		// 가장 작은 숫자 찾아 출력
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			min = Math.min(min, sum[N - 1][i]);
		}

		bw.append(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
