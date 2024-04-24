package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//78에서 실패
public class Q9466_2 {
	static boolean[] used, visit;
	static int[] arr;
	static int n, ans;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			used = new boolean[n + 1];
			visit = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 처음부터 돌자
			for (int i = 1; i <= n; i++) {
				if (!visit[i])
					dfs(i);
			}
			bw.append((n - ans) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int start) {
		if (used[start])
			return;
		if (visit[start]) {
			used[start] = true;
			ans++;
		}

		visit[start] = true;
		dfs(arr[start]);
		used[start] = true;
		visit[start] = false;
	}
}
