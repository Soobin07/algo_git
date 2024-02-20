package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//볼 모으기
public class Q17615 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 구슬 갯수
		int N = Integer.parseInt(br.readLine());
		// 구슬 모양
		char[] arr = br.readLine().toCharArray();

		// 움직임 최소
		int min = N;

		char[] color = { 'R', 'B' };
		// 지정 색 한쪽으로
		for (int c = 0; c < color.length; c++) {
			int cnt = 0; // 몇번 움직였나
			boolean flag = false; // 다른 색이 나왔나
			// 왼쪽으로 몰기
			for (int i = 0; i < N; i++) {
				// 다른 색이 나왔을 경우
				if (flag) {
					if (arr[i] == color[c])
						cnt++;
				} else if (arr[i] != color[c]) {
					flag = true;
				}
			}
			min = Math.min(min, cnt);

			cnt = 0;
			flag = false;
			// 오른쪽으로 몰기
			for (int i = N - 1; i >= 0; i--) {
				// 다른 색이 나왔을 경우
				if (flag) {
					if (arr[i] == color[c])
						cnt++;
				} else if (arr[i] != color[c]) {
					flag = true;
				}
			}
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}
}
