package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> d = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			d.add(i);
		}

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int m = 0; m < M; m++) {
			int stnd = Integer.parseInt(st.nextToken());
			while (true) {
				if (d.peek() == stnd) {
					d.poll();
					break;
				}

				int idx = searchIndex(d.toArray(new Integer[0]), stnd);
				if (idx > d.size() / 2) {
					int tmp = d.pollLast();
					d.addFirst(tmp);
				} else {
					int tmp = d.pollFirst();
					d.addLast(tmp);
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static int searchIndex(Integer[] arr, int stnd) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == stnd)
				return i;
		}
		return -1;
	}
}
