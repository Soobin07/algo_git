package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q15970 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int max = N;
		List<Integer>[] points = new ArrayList[max + 1];
		for (int c = 1; c <= max; c++) {
			points[c] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[y].add(x);
		}

		long sum = 0;
		for (int c = 1; c <= max; c++) {
			List<Integer> pts = points[c];
			if (pts.size() < 2)
				continue;

			Collections.sort(pts);

			for (int i = 0; i < pts.size(); i++) {
				int left = (i == 0) ? Integer.MAX_VALUE : pts.get(i) - pts.get(i - 1);
				int right = (i == pts.size() - 1) ? Integer.MAX_VALUE : pts.get(i + 1) - pts.get(i);
				sum += Math.min(left, right);
			}
		}
		System.out.println(sum);
	}
}