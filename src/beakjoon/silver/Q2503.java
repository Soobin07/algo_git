package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//숫자 야구
public class Q2503 {
	static LinkedList<String> list;
	static LinkedList<String> tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 편하게 해야지.
		// 1. 111 ~ 999 까지 넣는다
		// 2. 조건에 안맞으면 list에서 뺀다

		list = new LinkedList<String>();
		tmp = new LinkedList<String>();

		// 1. 넣는다
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j)
					continue;
				for (int k = 1; k < 10; k++) {
					if (i == k || j == k)
						continue;
					list.add(String.valueOf(i * 100 + j * 10 + k));
				}
			}
		}

		int N = Integer.parseInt(br.readLine()); // 질문 갯수
		// 질문
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String num = st.nextToken(); // 물어본 숫자
			int strike = Integer.parseInt(st.nextToken()); // 자리, 숫자 맞은 갯수
			int ball = Integer.parseInt(st.nextToken()); // 숫자 맞은 갯수

			// 답이 나왔네. 연산 중지.
			if (strike == 3) {
				System.out.println(1);
				break;
			}

			for (String str : list) {
				// strike 처리
				int s_cnt = 0;
				for (int i = 0; i < 3; i++) {
					if (str.charAt(i) == num.charAt(i))
						s_cnt++;
				}
				if (strike != s_cnt)
					continue;

				// strike 통과 후 ball 처리
				int b_cnt = 0;
				for (int i = 0; i < 3; i++) {
					if (str.indexOf(num.charAt(i)) >= 0)
						b_cnt++;
				}
				if (b_cnt - strike != ball)
					continue;

				// 둘 다 통과한 숫자
				tmp.add(str);
			}
			// 다음 질문 위한 초기화
			list.clear();
			list.addAll(tmp);
			tmp.clear();
		}

		System.out.println(list.size());
	}
}