package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1913 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine()); // 찾을 수
		int[][] map = new int[N][N];

		// 채우기
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int r = N / 2;
		int c = N / 2;
		int n = 1; // 넣는 숫자
		int cnt = 1; // 몇번씩 써야 하나

		map[r][c] = n++; // 1 넣기

		outer: while (r != 0 || c != 0) {
			for (int d = 0; d < 4; d++) {
				for (int t = 0; t < cnt; t++) {
					r += dr[d];
					c += dc[d];
					map[r][c] = n++;
					if (r == 0 && c == 0)
						break outer;
				}
				if (d % 2 == 1) {
					cnt++;
				}
			}
		}

		int fr = 0;
		int fc = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.append(map[i][j] + " ");

				if (F == map[i][j]) {
					fr = i + 1;
					fc = j + 1;
				}
			}
			bw.append("\n");
		}

		bw.append(fr + " " + fc);

		bw.flush();
		bw.close();
		br.close();
	}
}
