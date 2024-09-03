package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q2346 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		ArrayDeque<int[]> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			q.add(new int[] { i, Integer.parseInt(st.nextToken()) });
		}

		while (q.size() > 1) {
			int[] now = q.poll();
			bw.append(now[0] + " ");
			if (now[1] >= 0) {
				for (int i = 1; i < now[1]; i++) {
					q.add(q.poll());
				}
			} else {
				for (int i = 0; i < now[1] * -1; i++) {
					q.addFirst(q.pollLast());
				}
			}
		}
		bw.append(q.poll()[0] + "");

		bw.flush();
		bw.close();
		br.close();
	}
}
