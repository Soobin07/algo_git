package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Q2504 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Character> stack = new Stack<>();
		ArrayList<int[]> sum = new ArrayList<>();

		String std = "()[]";

		// 2 이상일 때 sum할 숫자 넣기
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int chr = std.indexOf(ch);
			if (chr % 2 == 0) { // 시작
				stack.add(str.charAt(i));
			} else {
				// 안맞으면 0 하고 끝
				if (stack.isEmpty() || std.charAt(chr - 1) != stack.peek()) {
					System.out.println(0);
					return;
				} else {
					// 맞으면 계산할 곳에 넣는다
					sum.add(new int[] { (1 + (chr + 1) / 2), stack.size() });
					stack.pop();
				}
			}
		}

		// 괄호 짝 안맞고 끝나면 넘어가자
		if (!stack.isEmpty() && stack.size() > 0) {
			System.out.println(0);
			return;
		}

		// 더할거 없으면? 넘어가자
		if (sum.size() == 0) {
			System.out.println(0);
			return;
		}
		// 더하자
		while (true) {
			if (sum.size() == 1)
				break;

			// 앞에서부터 탐색. 앞의 depth와 동일하거나 작은 곳을 찾는다
			for (int i = 1; i < sum.size(); i++) {
				// 동일. 더하자.
				if (sum.get(i - 1)[1] == sum.get(i)[1]) {
					sum.get(i - 1)[0] += sum.get(i)[0];
					sum.remove(i);
					break; // 다음 while로
				} else if (sum.get(i - 1)[1] > sum.get(i)[1]) {
					// 앞의 것이 더 큼 => 뒤의 것과 곱하고, depth는 뒤의 것으로
					sum.get(i)[0] *= sum.get(i - 1)[0];
					sum.remove(i - 1);
					break; // 다음 while로
				}
			}
		}
		System.out.println(sum.get(0)[0]);
	}
}
