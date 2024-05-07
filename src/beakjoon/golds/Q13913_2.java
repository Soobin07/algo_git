package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q13913_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			bw.append("0\n");
			bw.append(K + "");
		} else {
			Queue<Integer> q = new LinkedList<>();
			int[] parent = new int[100_001];
			int[] time = new int[100_001];
			q.add(N);
			time[N] = 1;

			while (!q.isEmpty()) {
				int now = q.poll();
				if (now == K)
					break;
				if (now * 2 <= 100_000 && time[now * 2] == 0) {
					time[now * 2] = time[now] + 1;
					parent[now * 2] = now;
					q.add(now * 2);
				}
				if (now + 1 <= 100_000 && time[now + 1] == 0) {
					time[now + 1] = time[now] + 1;
					parent[now + 1] = now;
					q.add(now + 1);
				}
				if (now - 1 >= 0 && time[now - 1] == 0) {
					time[now - 1] = time[now] + 1;
					parent[now - 1] = now;
					q.add(now - 1);
				}
			}

			bw.append((time[K] - 1) + "\n");

			Stack<Integer> s = new Stack<>();
			s.push(K);
			int idx = K;
			while (idx != N) {
				s.push(parent[idx]);
				idx = parent[idx];
			}
			while (!s.isEmpty()) {
				bw.append(s.pop() + " ");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
