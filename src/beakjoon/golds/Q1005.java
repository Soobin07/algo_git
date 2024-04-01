package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//ACM Craft
public class Q1005 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] time = new int[N + 1];
			int[] cost_sum = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				time[i + 1] = Integer.parseInt(st.nextToken());
				cost_sum[i + 1] = time[i + 1];
			}

			ArrayList[] link = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				link[i] = new ArrayList<Integer>();
			}

			HashSet<Integer> notFirst = new HashSet<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				link[A].add(B);
				notFirst.add(B);
			}

			Queue<Integer> q = new LinkedList<>();
			// 첫번째 것 부터 돌면서
			for (int i = 1; i <= N; i++) {
				// 바로 만들 수 있는 애들을 시작으로 삼는다
				if (notFirst.contains(i)) {
					continue;
				}
				q.clear();
				q.add(i);

				while (!q.isEmpty()) {
					int now = q.poll();
					// 얘로 만들 수 있는 애들을 모두 찾는다
					for (int j = 0; j < link[now].size(); j++) {
						int tmp = (int) link[now].get(j);
						// 지금까지 만든 애 + 만들어야 할 애의 시간이
						// 현재 만들어야 할 애 만드는 시간보다 짧으면 그냥 패스한다
						if (cost_sum[tmp] >= cost_sum[now] + time[tmp]) {
							continue;
						}
						cost_sum[tmp] = cost_sum[now] + time[tmp];
						q.add(tmp);
					}
				}
			}
			System.out.println(cost_sum[Integer.parseInt(br.readLine())]);
		}
	}
}
