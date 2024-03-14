package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//괄호 추가하기
public class Q16637_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine()); // str길이
		String str = br.readLine(); // 수식

		// len은 홀수이나 1부터 가능
		if (len == 1) {
			// 1이면 그냥 그거 내보내라
			System.out.println(str);
		} else {
			// 브루트포스 ( => 앞에서 음수로 가장 작은 수였다가 마지막에 *-1 이 나와서 가장 큰 수가 되는 부분 커버 위해서 브루트포스로 변경)
			ArrayList<int[]>[] memo = new ArrayList[len / 2 + 1];
			for (int i = 0; i < len / 2 + 1; i++) {
				memo[i] = new ArrayList<>();
			}

			// 해당 위치 계산시 나오는 숫자들 모두 저장한다
			// {계산 값, 0:괄호x, 1:괄호o}
			memo[0].add(new int[] { str.charAt(0) - '0', 0 });
			memo[1].add(new int[] { cul(str.charAt(0) - '0', str.charAt(1), str.charAt(2) - '0'), 0 });
			memo[1].add(new int[] { cul(str.charAt(0) - '0', str.charAt(1), str.charAt(2) - '0'), 1 });

			// 앞에서부터 계산
			for (int i = 3; i < len; i += 2) {
				int before = str.charAt(i - 1) - '0';
				char ch = str.charAt(i);
				int now = str.charAt(i + 1) - '0';

				int idx = (i + 1) / 2;
				// 순서대로 계산 시
				for (int[] tmp : memo[idx - 1]) {
					memo[idx].add(new int[] { cul(tmp[0], ch, now), 0 });
				}
				// 이번 연산에 괄호 쳤을 때
				int pri = cul(before, ch, now);
				for (int[] tmp : memo[idx - 2]) {
					memo[idx].add(new int[] { cul(tmp[0], str.charAt(i - 2), pri), 1 });
				}
			}

			// 마지막에 가장 큰 수 확인
			int biggest = Integer.MIN_VALUE;
			for (int[] tmp : memo[len / 2]) {
				biggest = Math.max(tmp[0], biggest);
			}
			System.out.println(biggest);
		}
	}

	static int cul(int a, char ch, int b) {
		if (ch == '+') {
			return a + b;
		} else if (ch == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}
