package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1238 {
	static class Node implements Comparable<Node> {
		int s, c;

		public Node() {
		}

		public Node(int s, int c) {
			this.s = s;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		// X를 시작으로 다익스트라
		// ways 넣기 (e에서 s를 알 수 있게)

		ArrayList<Node>[] ways = new ArrayList[N + 1];
		ArrayList<Node>[] r_ways = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			ways[i] = new ArrayList<>();
			r_ways[i] = new ArrayList<>();
		}

		// 길 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ways[s].add(new Node(e, c));
			r_ways[e].add(new Node(s, c));
		}

		// 다익스트라
		int[] cost1 = new int[N + 1];
		int[] cost2 = new int[N + 1];
		Arrays.fill(cost1, Integer.MAX_VALUE);
		Arrays.fill(cost2, Integer.MAX_VALUE);

		find(cost1, ways, X, N);
		find(cost2, r_ways, X, N);

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, cost1[i] + cost2[i]);
		}
		System.out.println(max);
	}

	static void find(int[] cost, ArrayList<Node>[] ways, int X, int N) {
		cost[X] = 0;

		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.s])
				continue;
			visit[now.s] = true;
			for (Node node : ways[now.s]) {
				if (cost[node.s] > cost[now.s] + node.c) {
					cost[node.s] = cost[now.s] + node.c;
					pq.add(new Node(node.s, cost[node.s]));
				}
			}
		}
	}
}
