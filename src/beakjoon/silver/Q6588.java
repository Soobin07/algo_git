package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6588 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		// 홀수 소수 찾아놓기
		boolean[] nums = new boolean[1_000_001];
		for (int i = 3; i < nums.length; i += 2) {
			if (nums[i])
				continue;
			for (int j = 2 * i; j < nums.length; j += i) {
				nums[j] = true;
			}
		}

		// 덧셈으로 표현하기
		out: while (true) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0)
				break;
			for (int i = 3; i < nums.length; i++) {
				if (i % 2 == 1 && !nums[i] && !nums[tmp - i]) {
					sb.append(tmp + " = " + i + " + " + (tmp - i) + "\n");
					continue out;
				}
			}
		}

		System.out.println(sb.toString());
	}
}
