package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18352 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, -1);
		dist[X] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(X);

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : graph.get(curr)) {
				if (dist[next] == -1) {
					dist[next] = dist[curr] + 1;
					q.add(next);
				}
			}
		}
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				bw.append(i + "\n");
				flag = true;
			}
		}
		if (!flag) {
			bw.append("-1");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
