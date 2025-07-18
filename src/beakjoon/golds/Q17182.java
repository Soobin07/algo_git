package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//괄호 추가하기
public class Q16637 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine()); // str길이
		String str = br.readLine(); // 수식

		// 수식을 앞에서부터 계산해 나가면서, 해당 숫자 위치에 오기까지 가장 큰 값을 찾는다
		// 계산 값 메모라이징 용. ( 수식의 반절+1은 숫자 갯수 )
		int[] ans_order = new int[len / 2 + 2]; // 해당 위치 괄호 없음
		int[] ans_pri = new int[len / 2 + 2]; // 해당 위치 괄호 있음

		// 첫번째 식은 그냥 입력하자 (계산 할 값이 변하지 않는다)
		ans_order[0] = ans_pri[0] = str.charAt(0) - '0'; // 첫 숫자는 계산 할 것이 없음 => 그대로가 가장 크다
		ans_order[1] = ans_pri[1] = cul(str.charAt(0) - '0', str.charAt(1), str.charAt(2) - '0'); // 첫번째 식은 그대로 계산한다

		// 앞에서부터 계산
		for (int i = 3; i < len; i += 2) {
			int before = str.charAt(i - 1) - '0';
			char ch = str.charAt(i);
			int now = str.charAt(i + 1) - '0';

			int idx = (i + 1) / 2;
			// 순서대로 계산 시
			ans_order[idx] = Math.max(cul(ans_order[idx - 1], ch, now), cul(ans_pri[idx - 1], ch, now));
			// 이번 연산을 중심으로 괄호 쳤을 때
			ans_pri[idx] = Math.max(cul(ans_order[idx - 2], str.charAt(i - 2), cul(before, ch, now)),
					cul(ans_pri[idx - 2], str.charAt(i - 2), cul(before, ch, now)));
		}

		// 마지막에 둘 중 큰 것을 넣어준다
		System.out.println(Math.max(ans_order[len / 2], ans_pri[len / 2]));
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
