package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//전기가 부족해
public class Q10423 {
	static int[] parents;

	static class Node implements Comparable<Node> {
		int u, v, w;

		public Node() {
		}

		public Node(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		parents = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			parents[n] = n;
		}
		for (int k = 0; k < K; k++) {
			int idx = Integer.parseInt(st.nextToken());
			parents[idx] = -1;
		}

		PriorityQueue<Node> cables = new PriorityQueue<>();
		int u, v, w;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			cables.add(new Node(u, v, w));
		}

		long cost = 0;
		for (int i = 0; i < M; i++) {
			Node n = cables.poll();
			if (find(n.v) != find(n.u)) {
				union(n.u, n.v);
				cost += n.w;
			}
		}

		System.out.println(cost);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa > 0 && pb > 0)
			parents[pa] = pb;
		else if (pa == -1)
			parents[pb] = pa;
		else if (pb == -1)
			parents[pa] = pb;
	}

	static int find(int a) {
		if (a == -1)
			return -1;
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}
