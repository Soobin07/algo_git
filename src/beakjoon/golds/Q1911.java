package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//흙길 보수하기
public class Q1911 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 웅덩이 갯수
		int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

		int[] starts = new int[N];
		int[] ends = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			starts[i] = Integer.parseInt(st.nextToken());
			ends[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		int s_idx = 0;
		int e_idx = 0;
		int cnt = 0;
		int last = 0;
		while (e_idx < N) {
			int start = Math.max(starts[s_idx], last);
			int end = ends[e_idx];

			if (ends[e_idx] < starts[s_idx]) {
				e_idx++;
				continue;
			}

			while (start < end) {
				start += L;
				cnt++;
			}

			last = start;
			s_idx++;
			e_idx++;
		}

		System.out.println(cnt);
	}
}
