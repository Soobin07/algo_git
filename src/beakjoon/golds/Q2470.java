package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2470 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> smalls = new PriorityQueue<Integer>();
		PriorityQueue<Integer> bigs = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			smalls.add(tmp);
			bigs.add(tmp);
		}

		int small = smalls.poll();
		int big = bigs.poll();
		long before = Long.MAX_VALUE;
		int a = 0;
		int b = 0;

		while (small != big) {
			long sum = 0L + big + small;
			if (Math.abs(sum) < before) {
				before = Math.abs(sum);
				a = big;
				b = small;
			}
			if (sum > 0) {
				big = bigs.poll();
			} else if (sum < 0) {
				small = smalls.poll();
			} else if (sum == 0) {
				break;
			}
		}

		System.out.println(b + " " + a);
	}
}
