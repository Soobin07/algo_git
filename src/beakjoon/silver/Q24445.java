package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Q24445 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] paths = new ArrayList[N + 1];
		for (int n = 1; n <= N; n++) {
			paths[n] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			paths[u].add(v);
			paths[v].add(u);
		}

		for (int n = 1; n <= N; n++) {
			Collections.sort(paths[n], Collections.reverseOrder());
		}

		int[] visit = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 1;

		visit[R] = cnt++;
		q.add(R);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : paths[now]) {
				if (visit[i] != 0) {
					continue;
				}
				visit[i] = cnt++;
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(visit[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
