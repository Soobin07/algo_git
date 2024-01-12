package beakjoon.silver;

import java.util.Scanner;

//팰린드롬
public class Q1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		// 어떤 문자가 몇개 있는지 확인
		int alp_cnt = 'Z' - 'A' + 1;
		int[] cnt_alp = new int[alp_cnt];

		for (int i = 0; i < str.length(); i++) {
			cnt_alp[str.charAt(i) - 'A']++;
		}

		// 팰린드롬 가능한지 여부
		boolean flag = true;
		int mid = -1;
		// 전체 글자 수가 짝수이면
		if (str.length() % 2 == 0) {
			// 전부 짝수여야 한다.
			for (int i = 0; i < alp_cnt; i++) {
				if (cnt_alp[i] % 2 != 0) {
					flag = false;
					break;
				}
			}
		} else {
			// 전체 홀수이면 홀수가 하나 있어야 한다.
			int odd_cnt = 0;
			for (int i = 0; i < alp_cnt; i++) {
				if (cnt_alp[i] % 2 != 0) {
					if (odd_cnt >= 2) {
						flag = false;
						break;
					}
					mid = i;
					odd_cnt++;
				}
			}
		}

		// 펠린드롬 불가능하면 치우자
		if (!flag) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			// 여기부터는 펠린드롬 가능
			StringBuffer sb = new StringBuffer();
			boolean[] used = new boolean[alp_cnt];

			// 알파벳 앞에서부터 2개 넘는 애들을 sb에 넣어준다
			for (int i = 0; i < str.length() / 2; i++) {
				for (int j = 0; j < alp_cnt; j++) {
					if (cnt_alp[j] >= 2) {
						sb.append((char) (j + 'A'));
						cnt_alp[j] -= 2;
						break;
					}
				}
			}

			// 만약 가운데가 있는 애면 지금 넣어준다
			if (mid != -1) {
				sb.append((char) (mid + 'A'));
			}

			String tmp = sb.toString();
			// 가운데 없으면 맨 끝도 반복
			if (mid == -1) {
				sb.append(tmp.charAt(tmp.length() - 1));
			}
			// 나머지는 맨 끝 빼고 반복
			for (int i = tmp.length() - 2; i >= 0; i--) {
				sb.append(tmp.charAt(i));
			}

			// 출력
			System.out.println(sb.toString());
		}
	}
}
