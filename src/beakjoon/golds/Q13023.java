package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q13023 {
	static ArrayList<Integer>[] fr;
	static boolean[] visit;
	static boolean found = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		fr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			fr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			fr[a].add(b);
			fr[b].add(a);
		}

		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			dfs(i, 1);
			if (found)
				break;
		}

		System.out.println(found ? 1 : 0);
	}

	static void dfs(int cur, int dep) {
		if (dep == 5) {
			found = true;
			return;
		}

		visit[cur] = true;

		for (int next : fr[cur]) {
			if (!visit[next]) {
				dfs(next, dep + 1);
				if (found)
					return;
			}
		}

		visit[cur] = false;
	}
}
