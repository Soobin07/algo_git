package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1922 {
	static int N, M;
	static int[] parents;

	static class Node implements Comparable<Node> {
		int a;
		int b;
		int c;

		public Node() {
		}

		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return c - o.c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			q.add(new Node(a, b, c));
		}

		long sum = 0;
		for (int i = 0; i < M; i++) {
			Node n = q.poll();
			if (find(n.a) != find(n.b)) {
				union(n.a, n.b);
				sum += n.c;
			}
		}
		System.out.println(sum);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parents[pa] = pb;
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}
