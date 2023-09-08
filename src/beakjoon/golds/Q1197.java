package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1197 {
	static int V, E;
	static int[] parents;

	static class Node implements Comparable<Node> {
		int from, go, weight;

		public Node(int from, int go, int weight) {
			this.from = from;
			this.go = go;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parents = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}
		Queue<Node> pq = new PriorityQueue<>();
		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		int size = pq.size();
		int sum = 0;
		for (int i = 0; i < size; i++) {
			Node node = pq.poll();
			int x = find(node.go);
			int y = find(node.from);
			if (x != y) {
				sum += node.weight;
				union(node.go, node.from);
			}
		}
		System.out.println(sum);
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parents[y] = x;
		}
	}
}
