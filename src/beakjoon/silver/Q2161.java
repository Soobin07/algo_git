package beakjoon.silver;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2161 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		// 아래가 제일 위다.
		while (q.size() >= 2) {
			System.out.print(q.poll() + " ");
			int n = q.poll();
			q.add(n);
		}
		System.out.print(q.poll());
	}
}
