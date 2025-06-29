package beakjoon.silver;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q2841 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();

		PriorityQueue<Integer>[] arr = new PriorityQueue[7];
		for (int i = 0; i < 7; i++) {
			arr[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

		int cnt = 0;
		for (int n = 0; n < N; n++) {
			int num = sc.nextInt();
			int plat = sc.nextInt();
			if (arr[num].size() == 0) {
				arr[num].add(plat);
				cnt++;
				continue;
			}
			while (arr[num].size() > 0 && arr[num].peek() > plat) {
				cnt++;
				arr[num].poll();
			}
			if (arr[num].size() > 0 && arr[num].peek() == plat) {
				continue;
			}
			cnt++;
			arr[num].add(plat);
		}

		System.out.println(cnt);
	}
}
