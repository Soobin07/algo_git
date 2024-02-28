package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나는 요리사다
public class Q2953 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int max_cost = 0;
		int max_idx = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if (max_cost < sum) {
				max_cost = sum;
				max_idx = i;
			}
		}
		System.out.println((max_idx + 1) + " " + max_cost);
	}
}
