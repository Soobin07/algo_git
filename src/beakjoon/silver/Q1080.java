package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1080 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] A = new boolean[N][M];
		boolean[][] B = new boolean[N][M];

		// A넣기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) == '0' ? false : true;
			}
		}
		// B넣기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) == '0' ? false : true;
			}
		}

		// 똑같으면 0
		int ans = 0;
		// 만약 3x3이 되지 않으면? 못바꿔
		if (N < 3 || M < 3) {
			// 될 수 없으면 -1
			if (!same(A, B)) {
				ans = -1;
			}
		} else {
			// 다르면 바꿔보자
			outer: for (int i = 0; i < N - 2; i++) {
				for (int j = 0; j < M - 2; j++) {
					if (A[i][j] == B[i][j]) {
						if (same(A, B))
							break outer;
						continue;
					}
					change(i, j, A);
					ans++;
				}
			}

			// 만약 마지막까지 돌렸는데 같지 않으면?
			if (!same(A, B)) {
				ans = -1;
			}
		}
		System.out.println(ans);
	}

	static void change(int r, int c, boolean[][] map) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map[r + i][c + j] = !map[r + i][c + j];
			}
		}
	}

	static boolean same(boolean[][] A, boolean[][] B) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != B[i][j])
					return false;
			}
		}
		return true;
	}
}
