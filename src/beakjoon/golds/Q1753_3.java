package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단 경로 : 최종
//비교가 필요할 경우 자료형 or 클래스. 형태를 맞춰주면 더 빠르게 비교할 수 있다
//필요 없는 부분까지 생각해서 만들지 마라 (weight가 같은 경우 현재 그대로 둬도 된다)
public class Q1753_3 {
	static int V, E;

	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		public Node() {
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수

		int start = Integer.parseInt(br.readLine()); // 시작점

		// 초기화
		ArrayList<Node>[] way = new ArrayList[V + 1]; // i정점에서 갈 수 있는 간선 (to, weight)
		for (int i = 1; i <= V; i++) {
			way[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			way[from].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// 다익스트라
		int[] cost = new int[V + 1]; // start에서 각 정점으로 가기 위해 필요한 비용
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			// 이미 아는 길이 더 빠를 때
			if (cost[now.to] < now.weight)
				continue;
			// 지금 있는 노드에서 주변 간선들을 다 돌았을 때
			for (Node next : way[now.to]) {
				// 지금 노드를 통해 다른 간선 거쳐가는 비용
				int sum = now.weight + next.weight;
				// key로 가기 위해 now.to를 거쳐 가는게 더 빨리 가는 경우
				if (cost[next.to] > sum) {
					cost[next.to] = sum;
					pq.add(new Node(next.to, sum));
				}
			}
		}

		// 출력
		for (int i = 1; i <= V; i++) {
			if (cost[i] == Integer.MAX_VALUE) {
				bw.append("INF\n");
			} else {
				bw.append(cost[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
