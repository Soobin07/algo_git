package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//카드 함체 놀이
public class Q15903 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 카드의 개수
		int m = Integer.parseInt(st.nextToken()); // 카드 합체 몇번

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < m; i++) {
			long min_a = pq.poll();
			long min_b = pq.poll();

			long sum = min_a + min_b;
			pq.add(sum);
			pq.add(sum);
		}

		long sum = 0L;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}

		System.out.println(sum);
	}
}
