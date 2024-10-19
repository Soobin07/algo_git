package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7795 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] a = new int[n];
			int[] b = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a);
			Arrays.sort(b);

			int sum = 0;
			for (int i = 0; i < n; i++) {
				int start = 0;
				int end = m - 1;
				int cnt = 0;

				while (start <= end) {
					int mid = (start + end) / 2;
					if (b[mid] < a[i]) {
						start = mid + 1;
						cnt = mid + 1;
					} else {
						end = mid - 1;
					}
				}
				sum += cnt;
			}

			System.out.println(sum);
		}
	}
}
