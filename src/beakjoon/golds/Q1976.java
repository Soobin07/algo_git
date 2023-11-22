package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1976 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 총 도시 수
		int N = Integer.parseInt(br.readLine());
		// 연결된 맵
		int[][] map = new int[N][N];

		// 여행 계획 세운 도시 수
		int M = Integer.parseInt(br.readLine());

		// 연결 된 도시 표시
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 도시 parent 초기화
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					union(i, j);
				}
			}
		}

		// 확인해야 할 연결된 도시
		st = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(st.nextToken()) - 1;
		String ans = "YES";
		conf: for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken()) - 1;
			if (!findParent(before, now)) {
				ans = "NO";
				break conf;
			}
		}
		System.out.println(ans);
	}

	static int getParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = getParent(parent[x]);
	}

	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	static boolean findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a == b)
			return true;
		else
			return false;
	}

}
