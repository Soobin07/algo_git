package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1051 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		int ans = 0;
		// 한 변의 크기
		int max = Math.min(N, M);
		outer: for (int i = max - 1; i >= 0; i--) {
			for (int r = 0; r < N - i; r++) { // 세로
				for (int c = 0; c < M - i; c++) { // 가로
					// 시작점
					int A = arr[r].charAt(c);
					int B = arr[r].charAt(c + i);
					if (A != B)
						continue;
					int C = arr[r + i].charAt(c);
					if (A != C)
						continue;
					int D = arr[r + i].charAt(c + i);
					if (A != D)
						continue;

					ans = (i + 1) * (i + 1);
					break outer;
				}
			}
		}

		System.out.println(ans);
	}
}
