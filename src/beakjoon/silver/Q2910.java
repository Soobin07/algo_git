package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2910 {
	static class Node implements Comparable<Node> {
		int no;
		int order;
		int cnt;

		public Node(int no, int cnt, int order) {
			this.no = no;
			this.cnt = cnt;
			this.order = order;
		}

		@Override
		public int compareTo(Node o) {
			if (o.cnt == cnt)
				return order - o.order;
			return o.cnt - cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> order = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
				order.put(n, i);
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		map.forEach((n, c) -> {
			pq.add(new Node(n, c, order.get(n)));
		});

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (int i = 0; i < now.cnt; i++) {
				bw.append(now.no + " ");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
