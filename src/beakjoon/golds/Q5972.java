package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//택배 배송
public class Q5972 {
	static int N, M; // 헛간 갯수, 길 갯수
	static int[] costs; // 해당 헛간 들어가는데 필요한 최소 cost
	static ArrayList<int[]>[] roads; // 해당 헛간과 이어진 길

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 헛간 갯수
		M = Integer.parseInt(st.nextToken()); // 길 갯수

		// 초기화
		costs = new int[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);

		roads = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			roads[i] = new ArrayList<int[]>();
		}

		// 길 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			roads[a].add(new int[] { b, cost });
			roads[b].add(new int[] { a, cost });
		}

		// 초기 위치 설정
		costs[1] = 0;
		// 돌아본다
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			// 만약 이미 가장 짧은 길로 왔다면 넘어가자
			if (costs[tmp[0]] < tmp[1])
				continue;

			// now에서 갈 수 있는 헛간 모두 돌아본다
			for (int i = 0; i < roads[tmp[0]].size(); i++) {
				int[] tmp2 = roads[tmp[0]].get(i);
				int c = tmp[1] + tmp2[1];
				if (c < costs[tmp2[0]]) {
					costs[tmp2[0]] = c;
					q.add(new int[] { tmp2[0], c });
				}
			}
		}
		System.out.println(costs[N]);
	}
}
