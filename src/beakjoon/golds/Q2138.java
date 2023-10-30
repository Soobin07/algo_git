package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] now = new boolean[N + 1];
		boolean[] dis = new boolean[N + 1];

		String str = br.readLine();
		for (int i = 1; i <= N; i++) {
			if (str.charAt(i - 1) == '0') {
				now[i] = true;
			} else {
				now[i] = false;
			}
		}
		str = br.readLine();
		for (int i = 1; i <= N; i++) {
			if (str.charAt(i - 1) == '0') {
				dis[i] = true;
			} else {
				dis[i] = false;
			}
		}

		int ans = -1;
		if (isSame(now, dis)) {
			// 처음부터 같을 때
			ans = 0;
		} else {
			// 1번 안누름
			boolean[] tmp = copy(now);
			int push1 = 0;
			for (int i = 2; i < tmp.length; i++) {
				if (tmp[i - 1] == dis[i - 1])
					continue;
				else {
					push(tmp, i);
					push1++;
				}
			}
			if (isSame(tmp, dis)) {
				ans = push1;
			}

			// 1번 누름
			boolean[] tmp2 = copy(now);
			int push2 = 1;
			push(tmp2, 1);
			for (int i = 2; i < tmp2.length; i++) {
				if (tmp2[i - 1] == dis[i - 1])
					continue;
				else {
					push(tmp2, i);
					push2++;
				}
			}
			if (isSame(tmp2, dis)) {
				if (ans == -1) {
					ans = push2;
				} else {
					ans = Math.min(ans, push2);
				}
			}
		}
		System.out.println(ans);
	}

	static boolean[] copy(boolean[] A) {
		boolean[] tmp = new boolean[A.length];
		for (int i = 0; i < A.length; i++) {
			tmp[i] = A[i];
		}
		return tmp;
	}

	static boolean isSame(boolean[] A, boolean[] B) {
		for (int i = 1; i < A.length; i++) {
			if (A[i] != B[i])
				return false;
		}
		return true;
	}

	static void push(boolean[] A, int i) {
		if (i - 1 > 0) {
			A[i - 1] = !A[i - 1];
		}
		A[i] = !A[i];
		if (i + 1 < A.length) {
			A[i + 1] = !A[i + 1];
		}
	}
}
