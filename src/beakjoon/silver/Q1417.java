package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//국회의원 선거
public class Q1417 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> votes = new PriorityQueue<>(Collections.reverseOrder());
		int vote = Integer.parseInt(br.readLine());
		for (int n = 1; n < N; n++) {
			votes.add(Integer.parseInt(br.readLine()));
		}

		int gap = 0;
		while (!votes.isEmpty() && votes.peek() >= vote) {
			vote++;
			votes.add(votes.poll() - 1);
			gap++;
		}
		System.out.println(gap);
	}
}
