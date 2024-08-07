package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}

		long before = 0;
		while (pq.size() > 1) {
			long tmp1 = pq.poll();
			long tmp2 = pq.poll();

			before += tmp1 + tmp2;
			pq.add(tmp1 + tmp2);
		}

		System.out.println(before);
	}
}
