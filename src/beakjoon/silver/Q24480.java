package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24480 {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int[] order;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점
		int M = Integer.parseInt(st.nextToken()); // 간선
		int R = Integer.parseInt(st.nextToken()); // 시작점

		// arr 초기화
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		// 간선 입력. 무방향 + 가중치1
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		// 내림차순으로 갈 수 있도록 sort
		for (int i = 0; i <= N; i++) {
			Collections.sort(arr[i], Collections.reverseOrder());
		}

		// visit, order 초기화
		visit = new boolean[N + 1];
		order = new int[N + 1];

		// 시작점 값 설정
		cnt = 0;
		dfs(R);

		for (int i = 1; i <= N; i++) {
			bw.append(order[i] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int start) {
		visit[start] = true;
		order[start] = ++cnt;

		for (int n : arr[start]) {
			if (!visit[n])
				dfs(n);
		}
	}
}
