package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5525_2 {
	static int N, M, ans;
	static char[] p, s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		p = new char[N * 2 + 1];
		for (int i = 0; i < p.length; i++) {
			if (i % 2 == 0)
				p[i] = 'I';
			else
				p[i] = 'O';
		}

		M = Integer.parseInt(br.readLine());
		s = br.readLine().toCharArray();

		int[] corr = new int[M];
		int i = 0;
		int j = 0;
		// i가 저 숫자를 넘어가면 패턴을 다 담지 못한다
		for (; i <= M - (N * 2 + 1); i++) {
			boolean flag = true;
			// 패턴과 얼마만큼 일치하는지 확인
			for (; j < N * 2 + 1; j++) {
				// 패턴과 str이 일치하면?
				if (p[j] == s[i + j]) {
					// 몇개째 일치하는가 확인 가능
					corr[i + j] = j + 1;
				} else {
					// 일치하지 않으면?
					flag = false;
					// 하나도 일치하지 않는 경우 그냥 넘어가기
					// 0보다 큰 경우, 이미 한번 s 어느정도 확인해 본 것이네?
					if (j > 0) {
						// 여기서 부터 다시 시작해야 할걸?
						i += (j - 1);
						j = 0;
					}
					break;
				}
			}
			// 전체가 일치하는 경우
			if (flag) {
				ans++;
				// i 두개 넘어가고
				i++;
				// j는 2개 넘어간 곳 부터 다시 확인 가능
				j = (N * 2 + 1) - 2;
			}
		}

		System.out.println(ans);
	}
}
