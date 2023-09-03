package beakjoon.golds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		HashMap<Integer, Integer> visit = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visit.put(N, 0);

		int min = Math.abs(K - N);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			int time = visit.get(tmp);

			if (tmp == K) {
				min = Math.min(time, min);
				continue;
			}
			if (tmp < K) {
				// *2
				if (!visit.containsKey(tmp * 2) || visit.get(tmp * 2) > time) {
					q.add(tmp * 2);
					visit.put(tmp * 2, time);
				}
				// +1
				if (tmp + 1 >= 0 && (time + 1) <= min
						&& (!visit.containsKey(tmp + 1) || visit.get(tmp + 1) > (time + 1))) {
					q.add(tmp + 1);
					visit.put(tmp + 1, time + 1);
				}
			}
			// -1
			if (tmp - 1 >= 0 && (time + 1) <= min && (!visit.containsKey(tmp - 1) || visit.get(tmp - 1) > (time + 1))) {
				q.add(tmp - 1);
				visit.put(tmp - 1, time + 1);
			}
		}

		System.out.println(min);
	}
}
