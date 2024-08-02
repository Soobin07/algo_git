package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11404 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수

		int[][] map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], 10_000_001);
		}

		for (int i = 0; i <= n; i++) {
			map[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 출발
			int e = Integer.parseInt(st.nextToken()); // 도착
			int c = Integer.parseInt(st.nextToken()); // 비용
			map[s][e] = Math.min(c, map[s][e]);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 10_000_001)
					map[i][j] = 0;

				bw.append(map[i][j] + " ");
			}
			bw.append("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
