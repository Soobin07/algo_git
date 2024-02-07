package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2607 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][26];
		int cnt = 0;
		// 갯수 저장
		int stnd = 0;
		for (int n = 0; n < N; n++) {
			String tmp = br.readLine();
			// 글자 갯수 확인
			for (int i = 0; i < tmp.length(); i++) {
				arr[n][tmp.charAt(i) - 'A']++;
			}
			// 가장 첫번째 단어의 크기 저장
			if (n == 0) {
				stnd = tmp.length();
				continue;
			}
			// 만약 글자 갯수가 +-1 넘어가면 그냥 넘어가자 (비슷한 단어 안됨)
			if (Math.abs(stnd - tmp.length()) > 1)
				continue;

			// 얼마나 다른지 확인
			int diff = 0;
			for (int i = 0; i < 26; i++) {
				// 갯수가 다른 경우 전부 들어감
				if (arr[0][i] != arr[n][i]) {
					diff += Math.abs(arr[0][i] - arr[n][i]);
				}
			}

			// diff가 1 이하면 갯수가 하나 다른 비슷한 단어
			// diff가 2 이하면 한글자 다른 비슷한 단어
			// 글자 갯수로 미리 판단했기 때문에 2개 이하 가능
			if (diff <= 2) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}