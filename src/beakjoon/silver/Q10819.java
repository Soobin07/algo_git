package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//차이를 최대로
public class Q10819 {
	static boolean[] visit;
	static int[] arr, select;
	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// N개의 정수로 이루어진 배열 A
		// 순서 바꿔서 |A[0]-A[1]| + |A[1]-A[2]| ... 최댓값 구하는 프로그램
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visit = new boolean[N];
		select = new int[N];
		comb(0);
		System.out.println(ans);
	}

	static void comb(int sel_idx) {
		if (sel_idx == N) {
			sum();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[sel_idx] = arr[i];
				comb(sel_idx + 1);
				visit[i] = false;
			}
		}
	}

	static void sum() {
		int tmp = 0;
		for (int i = 0; i < N - 1; i++) {
			tmp += Math.abs(select[i] - select[i + 1]);
		}
		ans = Math.max(tmp, ans);
	}
}
