package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15591 {
	static class Node{
		int no;
		int weight;
		public Node(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		// graph 기초공사
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}
		// 가중치 넣기
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, value));
			graph.get(b).add(new Node(a, value));
		}

		// 답 출력
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cnt = count(k, v, graph, N);
			bw.append(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int count(int k, int v, ArrayList<ArrayList<Node>> graph, int N) {
		boolean[] visit = new boolean[N+1];
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visit[v] = true;
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int i = 0 ; i < graph.get(current).size() ; i++) {
				int weight = graph.get(current).get(i).weight;
				int no = graph.get(current).get(i).no;
				//가장 작은 weight 따르니까, 현재 값이 weight보다 작은 것은 필요 없다!
				if(weight >= k && !visit[no]) {
					q.add(no);
					visit[no] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
