package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q2822 {
	static class Question implements Comparable<Question> {
		int num, score;

		public Question(int num, int score) {
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Question o) {
			if (o.score == score)
				return o.num - num;
			return o.score - score;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 8;
		PriorityQueue<Question> arr = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			arr.add(new Question(i + 1, Integer.parseInt(br.readLine())));
		}

		int sum = 0;
		ArrayList<Integer> ans_num = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Question tmp = arr.poll();
			sum += tmp.score;
			ans_num.add(tmp.num);
		}

		Collections.sort(ans_num);
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < ans_num.size(); i++) {
			ans.append(ans_num.get(i) + " ");
		}

		System.out.println(sum);
		System.out.println(ans.toString());
	}
}
