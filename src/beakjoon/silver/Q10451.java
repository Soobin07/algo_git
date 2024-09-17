package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10451 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			boolean[] visit = new boolean[N + 1];
			for (int i = 1; i < arr.length; i++) {
				if (visit[i])
					continue;

				int dist = arr[i];
				while (true) {
					if (visit[dist]) {
						cnt++;
						break;
					}
					visit[dist] = true;
					dist = arr[dist];
				}
			}
			System.out.println(cnt);
		}
	}
}
