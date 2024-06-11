package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q6198 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] buildings = new long[N + 1];
		for (int i = 0; i < N; i++) {
			buildings[i + 1] = Long.parseLong(br.readLine());
		}

		Stack<Long> stack = new Stack<>();
		long result = 0;

		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && stack.peek() <= buildings[i]) {
				stack.pop();
			}
			stack.add(buildings[i]);

			result += stack.size() - 1;
		}

		System.out.println(result);
	}
}