package beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q15828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt();
		while (n != -1) {
			if (n == 0) {
				q.poll();
			} else if (q.size() == N) {
			} else {
				q.add(n);
			}
			n = sc.nextInt();
		}
		StringBuffer sb = new StringBuffer();
		if (q.size() == 0) {
			sb.append("empty");
		} else {
			while (!q.isEmpty()) {
				sb.append(q.poll() + " ");
			}
		}

		System.out.println(sb.toString());
	}
}
